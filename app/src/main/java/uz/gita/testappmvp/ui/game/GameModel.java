package uz.gita.testappmvp.ui.game;

import java.util.ArrayList;
import java.util.List;

import uz.gita.testappmvp.model.TestData;
import uz.gita.testappmvp.repository.AppRepository;

public class GameModel implements GameContract.Model{
    private final AppRepository repository;
    private final List<TestData> listTests;
    private final int MAX_COUNT = 10;
    private int currentPos;
    private int wrongAnswer;
    private int correctAnswer;

    GameModel() {
        repository = AppRepository.getInstance();
        listTests = new ArrayList<>(MAX_COUNT);
        getTestData();
    }


    private void getTestData(){
        repository.shuffle();
        listTests.addAll(repository.getTestDataByCount(MAX_COUNT));
    }


    @Override
    public TestData getNextTest() {
        return listTests.get(currentPos++);
    }

    @Override
    public void check(String userAnswer) {
        if (listTests.get(currentPos-1).getAnswer().equals(userAnswer)){
            correctAnswer++;
        }else wrongAnswer++;
    }

    @Override
    public boolean hasQuestion() {
        return currentPos<MAX_COUNT;
    }

    @Override
    public int getCurrentPos() {
        return currentPos;
    }

    @Override
    public int getTotalCount() {
        return MAX_COUNT;
    }

    @Override
    public String getAnswer() {
        return listTests.get(currentPos-1).getAnswer();
    }

    @Override
    public int getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public int getWrongAnswer() {
        return wrongAnswer;
    }

    @Override
    public int getSkipAnswer() {
        return MAX_COUNT - correctAnswer - wrongAnswer;
    }

}
