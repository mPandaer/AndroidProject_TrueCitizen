package space.pandaer.truecitizen.model;

public class Question {
    private int ResId;
    private boolean answer;

    public Question(int resId, boolean answer) {
        ResId = resId;
        this.answer = answer;
    }

    public int getResId() {
        return ResId;
    }

    public void setResId(int resId) {
        ResId = resId;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
