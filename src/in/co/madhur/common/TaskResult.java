package in.co.madhur.common;

public class TaskResult<S, R> {

    private S taskId;
    private R result;

    public TaskResult(S taskId, R result) {
        this.taskId = taskId;
        this.result = result;
    }

    public S getTaskId() {
        return taskId;
    }

    public R getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskResult<?, ?> that = (TaskResult<?, ?>) o;

        if (taskId != null ? !taskId.equals(that.taskId) : that.taskId != null) return false;
        return result != null ? result.equals(that.result) : that.result == null;
    }

    @Override
    public int hashCode() {
        int result1 = taskId != null ? taskId.hashCode() : 0;
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "~~~~~TaskResult [taskId=" + taskId + ", result=" + result + "]~~~~~";
    }
}
