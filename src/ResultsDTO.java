public class ResultsDTO {
    double msecToCreateThreadObjects = 0.0;
    double msecToStartThreads = 0.0;
    double msecForConsumerThreadsProcessing = 0.0;
    double msecForProducerThreadsProcessing = 0.0;
    int itemsProducedByEachProducer = 0;
    int itemsConsumedByEachConsumer = 0;
    int numberOfProcessingProducerThreads = 0;
    int numberOfFinishedProducerThreads = 0;
    int numberOfPendingProducerThreads = 0;
    int numberOfProcessingConsumerThreads = 0;
    int numberOfFinishedConsumerThreads = 0;
    int numberOfPendingConsumerThreads = 0;
}
