package org.ei.opensrp.pregnantwoman;

/**
 * Created by YCCE on 18/04/16.
 */

import android.content.ContentValues;
import android.database.Cursor;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.sqlcipher.database.SQLiteDatabase;
import org.ei.opensrp.AllConstants;
import org.ei.opensrp.domain.EligibleCouple;
import  org.ei.opensrp.repository.DrishtiRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Boolean.TRUE;
import static java.text.MessageFormat.format;
import static net.sqlcipher.DatabaseUtils.longForQuery;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.repeat;
public class Pregnant_woman_repository extends DrishtiRepository {
    private static final String EC_SQL = "CREATE TABLE pregnant_woman(id VARCHAR PRIMARY KEY, details VARCHAR, isClosed VARCHAR)";
    public static final String ID_COLUMN = "id";
    public static final String DETAILS_COLUMN = "details";
    private static final String IS_CLOSED_COLUMN = "isClosed";
    public static final String pw_TABLE_NAME = "pregnant_woman";
    public static final String[] EC_TABLE_COLUMNS = new String[]{ID_COLUMN,DETAILS_COLUMN,IS_CLOSED_COLUMN};
    public static final String NOT_CLOSED = "false";
    private static final String IN_AREA = "false";

    @Override
    protected void onCreate(SQLiteDatabase database) {
        database.execSQL(EC_SQL);
    }


        public void add(PregnantWoman eligibleCouple) {
        SQLiteDatabase database = masterRepository.getWritableDatabase();
        database.insert(pw_TABLE_NAME, null, createValuesFor(eligibleCouple));
        }

    public void updateDetails(String caseId, Map<String, String> details) {
        SQLiteDatabase database = masterRepository.getWritableDatabase();
        PregnantWoman couple = findByCaseID(caseId);
        if (couple == null) {

            return;
        }


        ContentValues valuesToUpdate = new ContentValues();
        valuesToUpdate.put(DETAILS_COLUMN, new Gson().toJson(details));

        database.update(pw_TABLE_NAME, valuesToUpdate, ID_COLUMN + " = ?", new String[]{caseId});
}

        public void mergeDetails(String caseId, Map<String, String> details) {
        SQLiteDatabase database = masterRepository.getWritableDatabase();
        PregnantWoman couple = findByCaseID(caseId);
        if (couple == null) {
        return;
        }
        Map<String, String> mergedDetails = new HashMap<String, String>(couple.details());
        mergedDetails.putAll(details);
        ContentValues valuesToUpdate = new ContentValues();
        valuesToUpdate.put(DETAILS_COLUMN, new Gson().toJson(mergedDetails));
        database.update(pw_TABLE_NAME, valuesToUpdate, ID_COLUMN + " = ?", new String[]{caseId});
        }


        public List<PregnantWoman> allPregnantWoman() {
        SQLiteDatabase database = masterRepository.getReadableDatabase();
        Cursor cursor = database.query(pw_TABLE_NAME, EC_TABLE_COLUMNS, IS_CLOSED_COLUMN + " = ?", new String[]{ NOT_CLOSED}, null, null, null, null);
        return readAllPregnantWoman(cursor);
        }

        public List<PregnantWoman> findByCaseIDs(String... caseIds) {
        SQLiteDatabase database = masterRepository.getReadableDatabase();
        Cursor cursor = database.rawQuery(String.format("SELECT * FROM %s WHERE %s IN (%s)", pw_TABLE_NAME, ID_COLUMN, insertPlaceholdersForInClause(caseIds.length)), caseIds);
        return readAllPregnantWoman(cursor);
        }


        public PregnantWoman findByCaseID(String caseId) {
        SQLiteDatabase database = masterRepository.getReadableDatabase();
        Cursor cursor = database.query(pw_TABLE_NAME, EC_TABLE_COLUMNS, ID_COLUMN + " = ?", new String[]{caseId},null, null, null, null);
        List<PregnantWoman> couples = readAllPregnantWoman(cursor);
        if (couples.isEmpty()) {
        return null;
        }
        return couples.get(0);
        }

        public long count() {
        return longForQuery(masterRepository.getReadableDatabase(), "SELECT COUNT(1)￼FROM " + pw_TABLE_NAME +"WHERE" + IS_CLOSED_COLUMN + " = '" + NOT_CLOSED + "'", new String[0]);
         }

        public void close(String caseId) {
        ContentValues values = new ContentValues();
        masterRepository.getWritableDatabase().update(pw_TABLE_NAME, values, ID_COLUMN + " = ?", new String[]{caseId});
        }


            private ContentValues createValuesFor(PregnantWoman eligibleCouple) {
        ContentValues values = new ContentValues();
        values.put(ID_COLUMN, eligibleCouple.getCaseId());
        values.put(DETAILS_COLUMN, new Gson().toJson(eligibleCouple.details()));
        values.put(IS_CLOSED_COLUMN, Boolean.toString(eligibleCouple.isClosed()));
                values.put(IS_CLOSED_COLUMN, Boolean.toString(eligibleCouple.isClosed()));
                return values;
                }

    private List<PregnantWoman> readAllPregnantWoman(Cursor cursor) {
        cursor.moveToFirst();
        List<PregnantWoman> eligibleCouples = new ArrayList<PregnantWoman>();
        while (!cursor.isAfterLast()) {
            PregnantWoman eligibleCouple = new PregnantWoman(cursor.getString(0),new
                    Gson().<Map<String, String>>fromJson(cursor.getString(1), new TypeToken<Map<String,
                    String>>() {
            }.getType()),cursor.getString(2));
//
          //  eligibleCouple.setIsClosed();
            eligibleCouples.add(eligibleCouple);
            cursor.moveToNext();
        }

        cursor.close();
        return eligibleCouples;
        }

    private String insertPlaceholdersForInClause(int length) {
        return repeat("?", ",", length);
        }




    private List<Map<String, String>> readDetailsList(Cursor cursor) {
        cursor.moveToFirst();
        List<Map<String, String>> detailsList = new ArrayList<Map<String, String>>();
        while (!cursor.isAfterLast()) {
            String detailsJSON = cursor.getString(0);
            detailsList.add(new Gson().<Map<String, String>>fromJson(detailsJSON, new
                            TypeToken<HashMap<String, String>>() {
                            }.getType()));
            cursor.moveToNext();

    }
        cursor.close();
        return detailsList;
    }
}