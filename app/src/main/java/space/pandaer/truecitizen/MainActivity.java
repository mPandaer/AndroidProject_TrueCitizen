package space.pandaer.truecitizen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import space.pandaer.truecitizen.databinding.ActivityMainBinding;
import space.pandaer.truecitizen.model.Question;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Question> questions = new ArrayList<>();
    private ActivityMainBinding binding;
    private int currentQuestionIndex = 0;

    {
        questions.add(new Question(R.string.question_amendments, true));
        questions.add(new Question(R.string.question_government_senators, false));
        questions.add(new Question(R.string.question_government, true));
        questions.add(new Question(R.string.question_constitution, false));
        questions.add(new Question(R.string.question_government_feds, true));
        questions.add(new Question(R.string.question_declaration, true));
        questions.add(new Question(R.string.question_independence_rights, false));
        questions.add(new Question(R.string.question_religion, true));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.questionText.setText(questions.get(currentQuestionIndex).getResId());
        binding.nextButton.setOnClickListener(v -> {
            currentQuestionIndex = ++currentQuestionIndex % questions.size();
            updateQuestionText();
        });
        binding.prveButton.setOnClickListener(v -> {
            currentQuestionIndex = (--currentQuestionIndex + questions.size()) % questions.size();
            updateQuestionText();
        });
        binding.trueButton.setOnClickListener(v -> checkQuestionAnswer(true));
        binding.falseButton.setOnClickListener(v -> checkQuestionAnswer(false));


    }

    private void updateQuestionText() {
        binding.questionText.setText(questions.get(currentQuestionIndex).getResId());
    }

    private void checkQuestionAnswer(boolean userAnswer) {
        boolean answer = questions.get(currentQuestionIndex).isAnswer();
        int messageId = answer == userAnswer ? R.string.correct_answer : R.string.wrong_answer;
        Snackbar.make(binding.imageView, messageId, Snackbar.LENGTH_SHORT)
                .show();
    }
}