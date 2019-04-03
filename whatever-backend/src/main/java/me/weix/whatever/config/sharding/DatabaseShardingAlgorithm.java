package me.weix.whatever.config.sharding;

import io.shardingsphere.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * @author : weixiang
 * create at:  2019-04-03
 * @description: DatabaseShardingAlgorithm
 */
public final class DatabaseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(final Collection<String> availableTargetNames, final PreciseShardingValue<Long> shardingValue) {
        int size = availableTargetNames.size();
        for (String each : availableTargetNames) {
            if (each.endsWith(Long.parseLong(shardingValue.getValue() +"") % size + "")) {
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }
}
