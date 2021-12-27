package com.example.mycheesecakes.ui.quiz

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.mycheesecakes.databinding.QuizResultsQuestionsListItemBinding
import com.example.mycheesecakes.domain.model.quiz.Question

class QuizResultsAdapter(private val questions: List<Question>) :
    RecyclerView.Adapter<QuizResultsAdapter.ViewHolder>() {

    private lateinit var binding: QuizResultsQuestionsListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = QuizResultsQuestionsListItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(questions[position])
    }

    override fun getItemCount() = questions.size

    class ViewHolder(
        private val binding: QuizResultsQuestionsListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
            fun bind(question: Question) {
                binding.quizResultsQuestionTextview.text = question.question
                binding.quizResultsAnswerTextview.text = question.correctAnswer
                binding.quizResultsQuestionCheckImageview.isVisible = question.isCorrect
                if (!question.isCorrect) {
                    binding.root.setBackgroundColor(Color.RED)
                }
            }
    }
}