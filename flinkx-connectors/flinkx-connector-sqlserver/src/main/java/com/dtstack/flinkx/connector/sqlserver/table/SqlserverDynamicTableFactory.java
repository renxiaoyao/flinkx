/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dtstack.flinkx.connector.sqlserver.table;

import com.dtstack.flinkx.connector.jdbc.JdbcDialect;
import com.dtstack.flinkx.connector.jdbc.sink.JdbcOutputFormatBuilder;
import com.dtstack.flinkx.connector.jdbc.source.JdbcInputFormatBuilder;
import com.dtstack.flinkx.connector.jdbc.table.JdbcDynamicTableFactory;
import com.dtstack.flinkx.connector.sqlserver.SqlserverDialect;
import com.dtstack.flinkx.connector.sqlserver.sink.SqlserverOutputFormat;
import com.dtstack.flinkx.connector.sqlserver.source.SqlserverInputFormat;

/**
 * Company：www.dtstack.com
 *
 * @author shitou
 * @date 2021/5/21 17:39
 */
public class SqlserverDynamicTableFactory extends JdbcDynamicTableFactory {

    private static final String IDENTIFIER = "sqlserver-x";

    @Override
    public String factoryIdentifier() {
        return IDENTIFIER;
    }

    @Override
    protected JdbcDialect getDialect() {
        return new SqlserverDialect();
    }

    @Override
    protected JdbcInputFormatBuilder getInputFormatBuilder() {
        return new JdbcInputFormatBuilder(new SqlserverInputFormat());
    }

    @Override
    protected JdbcOutputFormatBuilder getOutputFormatBuilder() {
        return new JdbcOutputFormatBuilder(new SqlserverOutputFormat());
    }
}
