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

package com.dtstack.flinkx.connector.stream.lookup;

import com.dtstack.flinkx.connector.stream.conf.StreamLookupOptions;
import com.dtstack.flinkx.lookup.BaseAllTableFunction;

/**
 * @author chuixue
 * @create 2021-04-09 09:38
 * @description todo 参考flinkStreamSql v1.12的lookup模块
 **/
public class StreamAllLookupFunctionAll extends BaseAllTableFunction {

    public StreamAllLookupFunctionAll(
            StreamLookupOptions lookupOptions,
            String[] fieldNames,
            String[] keyNames) {
        super(fieldNames, keyNames, lookupOptions);
    }

    @Override
    protected void loadData(Object cacheRef) {
        // 具体的数据库加载数据
    }
}