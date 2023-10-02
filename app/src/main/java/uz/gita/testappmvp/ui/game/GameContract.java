package uz.gita.testappmvp.ui.game;

import uz.gita.testappmvp.model.TestData;

public interface GameContract {
    interface Model{
        TestData getNextTest();
        void check(String userAnswer);
        boolean hasQuestion();
        int getCurrentPos();
        int getTotalCount();
        String getAnswer();
        int getCorrectAnswer();
        int getWrongAnswer();
        int getSkipAnswer();

    }

    interface View{
        void clearOldAnswer();
        void describeTest(TestData testData, int currentPos, int totalCount);
        void stateNextButton(Boolean bool);
        void openResultDialog();
    }

    interface Presenter{
        void clickSkipButton();
        void clickNextButton();
        void selectUserAnswer(String userAnswer);
        boolean testAnswer(String userAnswer);
        int getCorrectAnswer();
        int getWrongAnswer();
        int getSkipAnswer();
    }

}
