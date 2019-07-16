/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dtstack.flinkx.binlog.reader;

import com.dtstack.flinkx.config.DataTransferConfig;
import com.dtstack.flinkx.config.ReaderConfig;
import com.dtstack.flinkx.reader.DataReader;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.types.Row;

import java.util.Map;

import static com.dtstack.flinkx.binlog.BinlogConfigKeys.*;

/**
 * company: www.dtstack.com
 * author: toutian
 * create: 2019/7/4
 */
public class BinlogReader extends DataReader {

    private String host;

    private int port;

    private String username;

    private String password;

    private Map<String,Object> start;

    private String filter;

    private String cat;

    private long period;

    private int bufferSize;

    public BinlogReader(DataTransferConfig config, StreamExecutionEnvironment env) {
        super(config, env);
        ReaderConfig readerConfig = config.getJob().getContent().get(0).getReader();
        start = (Map<String, Object>) readerConfig.getParameter().getVal(KEY_START);
        host = readerConfig.getParameter().getStringVal(KEY_HOST);
        port = readerConfig.getParameter().getIntVal(KEY_PORT, 3306);
        username = readerConfig.getParameter().getStringVal(KEY_USER_NAME);
        password = readerConfig.getParameter().getStringVal(KEY_PASSWORD);
        cat = readerConfig.getParameter().getStringVal(KEY_CATALOG);
        filter = readerConfig.getParameter().getStringVal(KEY_FILTER);
        period = readerConfig.getParameter().getLongVal(KEY_PERIOD, 1000L);
        bufferSize = readerConfig.getParameter().getIntVal(KEY_BUFFER_SIZE, 1024);
    }

    @Override
    public DataStream<Row> readData() {
        BinlogInputFormat format = new BinlogInputFormat();
        format.setHost(host);
        format.setPort(port);
        format.setUsername(username);
        format.setPassword(password);
        format.setCat(cat);
        format.setPeriod(period);
        format.setStart(start);
        format.setFilter(filter);
        format.setBufferSize(bufferSize);
        return createInput(format, "binlogreader");
    }
}