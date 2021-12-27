package com.example.mycheesecakes.ui.quiz

import android.graphics.Color
import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.mycheesecakes.R
import com.example.mycheesecakes.databinding.FragmentQuizBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class QuizFragment : Fragment(), View.OnClickListener {

    private lateinit var viewModel: QuizViewModel
    private lateinit var viewModelFactory: QuizViewModelFactory
    private lateinit var binding: FragmentQuizBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setupViewModel()
        binding = FragmentQuizBinding.inflate(inflater)
        setupButtons()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.questionLiveData.observe(viewLifecycleOwner) { question ->
            binding.apply {
                cheesecakeNameTextview.text = question.itemName
                cheesecakeQuestionTextview.text = question.question
                answer1Button.text = question.answers[0]
                answer2Button.text = question.answers[1]
                answer3Button.text = question.answers[2]
                answer4Button.text = question.answers[3]
            }
            Glide
                .with(this)
                .load(question.itemImageURL)
                .centerCrop()
                .placeholder(R.drawable.fresh_strawberry_cheesecake)
                .into(binding.cheesecakeImageview)
        }

        viewModel.timeRemaining.observe(viewLifecycleOwner) { time ->
            binding.countdownTimerTextView.text = time.toString()
        }


        viewModel.answerResult.observe(viewLifecycleOwner) { result ->
            showAnswerSnackbar(result)
        }

        viewModel.quizScore.observe(viewLifecycleOwner) { score ->
            val action = QuizFragmentDirections.actionQuizFragmentToQuizResultsSimpleFragment(score.correct,(score.correct + score.incorrect))
            findNavController().navigate(action)
        }

        viewModel.errorRetrievingData.observe(viewLifecycleOwner) { error ->
            if (error) {
                Toast.makeText(context,"Unable to create quiz. Check your internet connection and try again.", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        viewModel.fragmentOnStopCalled()
    }

    private fun setActionBarTitle(category: Int) {
        activity?.actionBar?.title = when(category) {
            0 -> "Quiz: Chocolate Cheesecakes"
            1 -> "Quiz: Fruit Cheesecakes"
            2 -> "Quiz: Other Cheesecakes"
            else -> "Error"
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onClick(view: View?) {
        when (view) {
            binding.answer1Button -> {
                viewModel.onQuestionAnswered(binding.answer1Button.text.toString())
            }
            binding.answer2Button -> {
                viewModel.onQuestionAnswered(binding.answer2Button.text.toString())
            }
            binding.answer3Button -> {
                viewModel.onQuestionAnswered(binding.answer3Button.text.toString())
            }
            binding.answer4Button -> {
                viewModel.onQuestionAnswered(binding.answer4Button.text.toString())
            }
        }
    }


    private fun showAnswerSnackbar(result: String) {
        context?.let { context ->
            Snackbar.make(context, binding.root, result, Snackbar.LENGTH_SHORT)
                .setBackgroundTint(Color.parseColor("#FEFBF7E6"))
                .setTextColor(Color.parseColor("#824D3B"))
                .show()
        }
    }

    private fun setupViewModel() {
        val arguments = QuizFragmentArgs.fromBundle(requireArguments())
        viewModelFactory = QuizViewModelFactory(arguments.category)
        viewModel = ViewModelProvider(this, viewModelFactory).get(QuizViewModel::class.java)
    }

    private fun setupButtons() {
        binding.answer1Button.setOnClickListener(this)
        binding.answer2Button.setOnClickListener(this)
        binding.answer3Button.setOnClickListener(this)
        binding.answer4Button.setOnClickListener(this)

    }

    override fun onPause() {
        super.onPause()
        viewModel.fragmentOnPauseCalled()
    }

    override fun onResume() {
        super.onResume()
        viewModel.fragmentOnResumeCalled()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isRemoving || isDetached) {
            activity?.viewModelStore?.clear()
        }
    }
}