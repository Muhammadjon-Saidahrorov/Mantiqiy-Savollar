package uz.gita.testappmvp.ui.game;

public class GamePresenter implements GameContract.Presenter{
    private GameContract.Model model;
    private GameContract.View view;
    private String userAnswer;

    public GamePresenter(GameContract.View view) {
        this.model = new GameModel();
        this.view = view;

        loadNextTest();
    }

    private void loadNextTest(){
        if (model.hasQuestion()) {
            view.clearOldAnswer();
            view.describeTest(model.getNextTest(), model.getCurrentPos(), model.getTotalCount());
        } else {
            view.openResultDialog();
        }
    }

    @Override
    public void clickSkipButton() {
        loadNextTest();
    }

    @Override
    public void clickNextButton() {
        model.check(userAnswer);
        loadNextTest();
        view.stateNextButton(false);
    }

    @Override
    public void selectUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
        view.stateNextButton(true);
    }

    @Override
    public boolean testAnswer(String userAnswer) {
        return model.getAnswer().equals(userAnswer);
    }

    @Override
    public int getCorrectAnswer() {
        return model.getCorrectAnswer();
    }

    @Override
    public int getWrongAnswer() {
        return model.getWrongAnswer();
    }

    @Override
    public int getSkipAnswer() {
        return model.getSkipAnswer();
    }

}
