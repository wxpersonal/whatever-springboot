package me.weix.whatever.config;

import io.shardingsphere.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * @author : weixiang
 * create at:  2019-03-19
 * @description: 一致性hash分片
 */
public class ConsistentHashAlgorithm implements PreciseShardingAlgorithm<Integer> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Integer> shardingValue) {

        //ConsistentHashAlgorithm
        for (String availableTargetName : availableTargetNames) {
            if(hash(availableTargetName).equals(shardingValue)) {
                return availableTargetName;
            }
        }

        return null;
    }

    public Integer hash(String s) {
        return 1;
    }
}
