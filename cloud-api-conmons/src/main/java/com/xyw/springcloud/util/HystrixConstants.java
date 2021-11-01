package com.xyw.springcloud.util;

/**
 * @Author lenovo
 * @Date 2021/3/10 9:40
 * @Version 1.0
 */
public interface HystrixConstants {
    /**
     * @TIMEOUT_IN_MILLISECONDS
     * 超时峰值
     */
    public static final String TIMEOUT_IN_MILLISECONDS = "execution.isolation.thread.timeoutInMilliseconds";
    public static final String TIMEOUT_ENBALE = "execution.timeout.enabled";
    public static final String CIRCUITBREAKER_ENABLE = "circuitBreaker.enabled";//是否启动断路器
    public static final String CURCUITBREAKER_REQUEST_VOLUNMET_THRESHOLD = "circuitBreaker.requestVolumeThreshold";//请求次数
    public static final String CIRCUITBREAKER_SPLEEPWINDW_IN_MILLISECONDS = "circuitBreaker.sleepWindowInMilliseconds";//时间范围
    public static final String CIRCUITBREAKER_ERROR_THRESHOLD_PERCENTAGE = "circuitBreaker.errorThresholdPercentage";//失败率阈值

    /**
     * hystrix.command.default和hystrix.threadpool.default中的default为默认CommandKey
     *
     * Command Properties
     * Execution相关的属性的配置：
     * execution.isolation.strategy 隔离策略，默认是Thread, 可选Thread｜Semaphore
     *
     * execution.isolation.thread.timeoutInMilliseconds 命令执行超时时间，默认1000ms
     *
     * execution.timeout.enabled 执行是否启用超时，默认启用true
     * execution.isolation.thread.interruptOnTimeout 发生超时是是否中断，默认true
     * execution.isolation.semaphore.maxConcurrentRequests 最大并发请求数，默认10，该参数当使用ExecutionIsolationStrategy.SEMAPHORE策略时才有效。如果达到最大并发请求数，请求会被拒绝。理论上选择semaphore size的原则和选择thread size一致，但选用semaphore时每次执行的单元要比较小且执行速度快（ms级别），否则的话应该用thread。
     * semaphore应该占整个容器（tomcat）的线程池的一小部分。
     * Fallback相关的属性
     * 这些参数可以应用于Hystrix的THREAD和SEMAPHORE策略
     *
     * fallback.isolation.semaphore.maxConcurrentRequests 如果并发数达到该设置值，请求会被拒绝和抛出异常并且fallback不会被调用。默认10
     * fallback.enabled 当执行失败或者请求被拒绝，是否会尝试调用hystrixCommand.getFallback() 。默认true
     * Circuit Breaker相关的属性
     * circuitBreaker.enabled 用来跟踪circuit的健康性，如果未达标则让request短路。默认true
     * circuitBreaker.requestVolumeThreshold 一个rolling window内最小的请求数。如果设为20，那么当一个rolling window的时间内（比如说1个rolling window是10秒）收到19个请求，即使19个请求都失败，也不会触发circuit break。默认20
     * circuitBreaker.sleepWindowInMilliseconds 触发短路的时间值，当该值设为5000时，则当触发circuit break后的5000毫秒内都会拒绝request，也就是5000毫秒后才会关闭circuit。默认5000
     * circuitBreaker.errorThresholdPercentage错误比率阀值，如果错误率>=该值，circuit会被打开，并短路所有请求触发fallback。默认50
     * circuitBreaker.forceOpen 强制打开熔断器，如果打开这个开关，那么拒绝所有request，默认false
     * circuitBreaker.forceClosed 强制关闭熔断器 如果这个开关打开，circuit将一直关闭且忽略circuitBreaker.errorThresholdPercentage
     * Metrics相关参数
     * metrics.rollingStats.timeInMilliseconds 设置统计的时间窗口值的，毫秒值，circuit break 的打开会根据1个rolling window的统计来计算。若rolling window被设为10000毫秒，则rolling window会被分成n个buckets，每个bucket包含success，failure，timeout，rejection的次数的统计信息。默认10000
     * metrics.rollingStats.numBuckets 设置一个rolling window被划分的数量，若numBuckets＝10，rolling window＝10000，那么一个bucket的时间即1秒。必须符合rolling window % numberBuckets == 0。默认10
     */
}
