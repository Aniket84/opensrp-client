/**
 * Copyright (c) 2015 Cloudant, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package com.cloudant.sync.notifications;

import com.cloudant.sync.replication.ErrorInfo;
import com.cloudant.sync.replication.Replicator;

/**
 * <p>Event posted when a state transition to ERROR is completed.</p>
 *
 * <p>Errors may include things such as:</p>
 *
 * <ul>
 *      <li>incorrect credentials</li>
 *      <li>network connection unavailable</li>
 * </ul>
 *
 */
public class ReplicationErrored {

    public ReplicationErrored(Replicator replicator, ErrorInfo errorInfo) {
        this.replicator = replicator;
        this.errorInfo = errorInfo;
    }

    /** 
     * The {@code Replicator} issuing the event
     */
    public final Replicator replicator;

    /** 
     * Error information about the error that occurred
     */
    public final ErrorInfo errorInfo;
    
    @Override
    public boolean equals(Object other) {
        if (other instanceof ReplicationErrored) {
            ReplicationErrored re = (ReplicationErrored)other;
            return this.replicator == re.replicator && this.errorInfo == re.errorInfo;
        }
        return false;
    }

}
