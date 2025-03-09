package br.com.transaction.management.dto;

import java.util.DoubleSummaryStatistics;

public class StatisticResponse {

    private Double sum;
    private Double avg;
    private Double max;
    private Double min;
    private Long count;

    public StatisticResponse(DoubleSummaryStatistics statistics) {
        this.sum = statistics.getSum();
        this.avg = statistics.getAverage();
        this.max = statistics.getMax();
        this.min = statistics.getMin();
        this.count = statistics.getCount();
    }

    public Double getSum() {
        return sum;
    }

    public Double getAvg() {
        return avg;
    }

    public Double getMax() {
        return max;
    }

    public Double getMin() {
        return min;
    }

    public Long getCount() {
        return count;
    }
}
