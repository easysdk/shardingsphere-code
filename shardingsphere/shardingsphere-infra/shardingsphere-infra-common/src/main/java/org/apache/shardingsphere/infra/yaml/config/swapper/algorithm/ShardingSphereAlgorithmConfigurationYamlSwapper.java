/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.infra.yaml.config.swapper.algorithm;

import org.apache.shardingsphere.infra.config.algorithm.ShardingSphereAlgorithmConfiguration;
import org.apache.shardingsphere.infra.yaml.config.pojo.algorithm.YamlShardingSphereAlgorithmConfiguration;
import org.apache.shardingsphere.infra.yaml.config.swapper.YamlConfigurationSwapper;

/**
 * ShardingSphere algorithm configuration YAML swapper.
 */
public final class ShardingSphereAlgorithmConfigurationYamlSwapper implements YamlConfigurationSwapper<YamlShardingSphereAlgorithmConfiguration, ShardingSphereAlgorithmConfiguration> {
    
    @Override
    public YamlShardingSphereAlgorithmConfiguration swapToYamlConfiguration(final ShardingSphereAlgorithmConfiguration data) {
        if (null == data) {
            return null;
        }
        YamlShardingSphereAlgorithmConfiguration result = new YamlShardingSphereAlgorithmConfiguration();
        result.setType(data.getType());
        result.setProps(data.getProps());
        return result;
    }
    
    @Override
    public ShardingSphereAlgorithmConfiguration swapToObject(final YamlShardingSphereAlgorithmConfiguration yamlConfig) {
        if (null == yamlConfig) {
            return null;
        }
        return new ShardingSphereAlgorithmConfiguration(yamlConfig.getType(), yamlConfig.getProps());
    }
}
