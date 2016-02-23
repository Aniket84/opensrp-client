package org.ei.opensrp.SteppingStoneChildrens;

import android.content.ContentValues;
import android.database.Cursor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.sqlcipher.database.SQLiteDatabase;

import org.ei.opensrp.SteppingStoneChildrens.SteppingStoneChildren;
import org.ei.opensrp.repository.DrishtiRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Boolean.TRUE;
import static net.sqlcipher.DatabaseUtils.longForQuery;
import static org.apache.commons.lang3.StringUtils.repeat;

public class SteppingStoneChildRepository extends DrishtiRepository {
    private static final String EC_SQL = "CREATE TABLE ss_children(id VARCHAR PRIMARY KEY, details VARCHAR)";
    public static final String ID_COLUMN = "id";


    public static final String DETAILS_COLUMN = "details";
    private static final String IS_CLOSED_COLUMN = "isClosed";

    public static final String EC_TABLE_NAME = "ss_children";
    public static final String[] EC_TABLE_COLUMNS = new String[]{ID_COLUMN,  DETAILS_COLUMN,};

    public static final String NOT_CLOSED = "false";
    private static final String IN_AREA = "false";

    @Override
    protected void onCreate(SQLiteDatabase database) {
        database.execSQL(EC_SQL);
    }

    public void add(SteppingStoneChildren sschild) {
        SQLiteDatabase database = masterRepository.getWritableDatabase();
        database.insert(EC_TABLE_NAME, null, createValuesFor(sschild));
    }

    public void updateDetails(String caseId, Map<String, String> details) {
        SQLiteDatabase database = masterRepository.getWritableDatabase();

        SteppingStoneChildren child = findByCaseID(caseId);
        if (child == null) {
            return;
        }

        ContentValues valuesToUpdate = new ContentValues();
        valuesToUpdate.put(DETAILS_COLUMN, new Gson().toJson(details));
        database.update(EC_TABLE_NAME, valuesToUpdate, ID_COLUMN + " = ?", new String[]{caseId});
    }

    public void mergeDetails(String caseId, Map<String, String> details) {
        SQLiteDatabase database = masterRepository.getWritableDatabase();

        SteppingStoneChildren child = findByCaseID(caseId);
        if (child == null) {
            return;
        }

        Map<String, String> mergedDetails = new HashMap<String, String>(child.details());
        mergedDetails.putAll(details);
        ContentValues valuesToUpdate = new ContentValues();
        valuesToUpdate.put(DETAILS_COLUMN, new Gson().toJson(mergedDetails));
        database.update(EC_TABLE_NAME, valuesToUpdate, ID_COLUMN + " = ?", new String[]{caseId});
    }

    public  List<SteppingStoneChildren> allSteppingStoneChildren() {
        SQLiteDatabase database = masterRepository.getReadableDatabase();
        Cursor cursor = database.query(EC_TABLE_NAME, EC_TABLE_COLUMNS,
               null,null, null, null, null);
      //  String queryString = "SELECT * FROM "+EC_TABLE_NAME;
     //   Cursor cursor = database.rawQuery(queryString,null);
        return readAllChildren(cursor);



    }

    public List<SteppingStoneChildren> findByCaseIDs(String... caseIds) {
        SQLiteDatabase database = masterRepository.getReadableDatabase();
        Cursor cursor = database.rawQuery(String.format("SELECT * FROM %s WHERE %s IN (%s)", EC_TABLE_NAME, ID_COLUMN,
                insertPlaceholdersForInClause(caseIds.length)), caseIds);
        return readAllChildren(cursor);
    }

    private String insertPlaceholdersForInClause(int length) {
        return repeat("?", ",", length);
    }

    public SteppingStoneChildren findByCaseID(String caseId) {
        SQLiteDatabase database = masterRepository.getReadableDatabase();
        Cursor cursor = database.query(EC_TABLE_NAME, EC_TABLE_COLUMNS, ID_COLUMN + " = ?", new String[]{caseId},
                null, null, null, null);
        List<SteppingStoneChildren> child = readAllChildren(cursor);
        if (child.isEmpty()) {
            return null;
        }
        return child.get(0);
    }

    public long count() {
        return longForQuery(masterRepository.getReadableDatabase(), "SELECT COUNT(1) FROM " + EC_TABLE_NAME
                +  "'", new String[0]);
    }

    public List<String> villages() {
       /* SQLiteDatabase database = masterRepository.getReadableDatabase();
        Cursor cursor = database.query(true, EC_TABLE_NAME, new String[]{VILLAGE_NAME_COLUMN}, IS_OUT_OF_AREA_COLUMN +
                " = ? AND " + IS_CLOSED_COLUMN + " = ?", new String[]{IN_AREA, NOT_CLOSED}, null, null, null, null);
        cursor.moveToFirst();
        List<String> villages = new ArrayList<String>();
        while (!cursor.isAfterLast()) {
            villages.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();*/
        return null;
    }



    public void close(String caseId) {
        ContentValues values = new ContentValues();
        values.put(IS_CLOSED_COLUMN, TRUE.toString());
        masterRepository.getWritableDatabase().update(EC_TABLE_NAME, values, ID_COLUMN + " = ?", new String[]{caseId});
    }

    private ContentValues createValuesFor(SteppingStoneChildren sschild) {
        ContentValues values = new ContentValues();
        values.put(ID_COLUMN, sschild.getCaseId());

        values.put(DETAILS_COLUMN, new Gson().toJson(sschild.details()));


        return values;
    }

    private List<SteppingStoneChildren> readAllChildren(Cursor cursor) {
        cursor.moveToFirst();
        List<SteppingStoneChildren> childrens = new ArrayList<SteppingStoneChildren>();
        while (!cursor.isAfterLast()) {
            SteppingStoneChildren child = new SteppingStoneChildren(cursor.getString(0),new
                    Gson().<Map<String, String>>fromJson(cursor.getString(1), new TypeToken<Map<String,
                    String>>() {
            }.getType()));

            childrens.add(child);
            cursor.moveToNext();
        }
        cursor.close();
        return childrens;
    }



    private List<Map<String, String>> readDetailsList(Cursor cursor) {
        cursor.moveToFirst();
        List<Map<String, String>> detailsList = new ArrayList<Map<String, String>>();
        while (!cursor.isAfterLast()) {
            String detailsJSON = cursor.getString(0);
            detailsList.add(new Gson().<Map<String, String>>fromJson(detailsJSON, new TypeToken<HashMap<String, String>>() {
            }.getType()));
            cursor.moveToNext();
        }
        cursor.close();
        return detailsList;
    }
}
