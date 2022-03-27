package com.androidquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.androidquiz.databinding.FragmentGameBinding


class GameFragment : Fragment() {
    data class Question(
        val text: String,
        val answers: List<String>
    )

    private val questions: MutableList<Question> = mutableListOf(
        Question(
            text = "What is Android Jetpack?",
            answers = listOf("all of these", "tools", "documentation", "libraries")
        ),
        Question(
            text = "Base class for Layout?",
            answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")
        ),
        Question(
            text = "Layout for complex Screens?",
            answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")
        ),
        Question(
            text = "Pushing structured data into a Layout?",
            answers = listOf("Data Binding", "Data Pushing", "Set Text", "OnClick")
        ),
        Question(
            text = "Inflate layout in fragments?",
            answers = listOf("onCreateView", "onViewCreated", "onCreateLayout", "onInflateLayout")
        ),
        Question(
            text = "Build system for Android?",
            answers = listOf("Gradle", "Graddle", "Grodle", "Groyle")
        ),
        Question(
            text = "Android vector format?",
            answers = listOf(
                "VectorDrawable",
                "AndroidVectorDrawable",
                "DrawableVector",
                "AndroidVector"
            )
        ),
        Question(
            text = "Android Navigation Component?",
            answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")
        ),
        Question(
            text = "Registers app with launcher?",
            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")
        ),
        Question(
            text = "Mark a layout for Data Binding?",
            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>")
        ),
//////
        Question(
            text = "Screen layouts are in the ...",
            answers = listOf("Res folder", "Java folder", "AndroidManifest", "Gradle scripts")
        ),
        Question(
            text = "Kotlin code is in the ...",
            answers = listOf("Java folder", "Res folder", "AndroidManifest", "Gradle scripts")
        ),
        Question(
            text = "Images are in the ...",
            answers = listOf("Res folder", "Java folder", "AndroidManifest", "Gradle scripts")
        ),
        Question(
            text = "App Permissions are in the ...",
            answers = listOf("AndroidManifest", "Res folder", "Java folder", "Gradle scripts")
        ),
        Question(
            text = "Code to build and run the app ...",
            answers = listOf("Gradle scripts", "Res folder", "Java folder", "AndroidManifest")
        ),

        ///////////////

        Question(
            text = "What View is used to display text to the user?",
            answers = listOf("TextView", "EditText", "TextArea", "Text")
        ),

        Question(
            text = "What View is used to display images to the user?",
            answers = listOf("ImageView", "Image", "Picture", "PictureView")
        ),

        ///////////////

        Question(
            text = "Images stored within the application are stored as which resource type?",
            answers = listOf("Drawable", "Image", "Picture", "PictureView")
        ),

        Question(
            text = "Dependencies required to build the project or enable additional functionality are defined in __",
            answers = listOf("build.gradle", "Resources", "Manifest", "Src")
        ),

        //////////////////

        Question(
            text = "A ____ resource can hold multiple attributes and be applied to a View as a single value.",
            answers = listOf("style", "set", "group", "connection")
        ),

        Question(
            text = "Which of the following should NOT be stored as a resource?",
            answers = listOf(
                "None of the above",
                "Color Only",
                "Color and String",
                "String and Style "
            )
        ),

        Question(
            text = "Aligning TextViews with different styles can be accomplished with _ constraint.",
            answers = listOf("Baseline", "Bottom", "Top", "Vertical")
        ),

        Question(
            text = "____ is used to create space outside of an object.",
            answers = listOf("margin", "padding", "spacing", "gap")
        ),

        Question(
            text = "ConstraintLayout is more efficient than LinearLayout for simple UIs with few Views",
            answers = listOf("False", "True", "Maybe", "Seldom")
        ),

        Question(
            text = "ConstraintLayout is more efficient than nested LinearLayouts for more complex UIs",
            answers = listOf("True", "False", "Maybe", "Seldom")
        )
    )

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private var numQuestions = Math.min(questions.size + 1, 3)


    /////////////////
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater,
            R.layout.fragment_game,
            container,
            false
        )
        randomizeQuestions()
        binding.game = this

        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            val chekedId = binding.questionRadioGroup.checkedRadioButtonId
            if (-1 != chekedId) {
                var answerIndex = 0
                when (chekedId) {
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                    R.id.fourthAnswerRadioButton -> answerIndex = 3
                }
                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    questionIndex++

                    if (questionIndex < numQuestions) {
                        currentQuestion = questions[questionIndex]
                        setQuestions()
                        binding.invalidateAll()

                    } else {
                        //WE WON

                    }


                } else {
                    //GameOver

                }


            }

        }


        return binding.root


    }

////////////////

    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestions()


    }

    private fun setQuestions() {

        currentQuestion = questions[questionIndex]
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()
        (activity as AppCompatActivity).supportActionBar?.title =
            "Android Trivia ({questionIndex+1}/{numQuestions})"


    }


}