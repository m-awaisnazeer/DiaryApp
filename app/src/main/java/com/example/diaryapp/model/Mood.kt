package com.example.diaryapp.model

import androidx.compose.ui.graphics.Color
import com.example.diaryapp.R
import com.example.diaryapp.ui.theme.AngryColor
import com.example.diaryapp.ui.theme.AwfulColor
import com.example.diaryapp.ui.theme.BoredColor
import com.example.diaryapp.ui.theme.CalmColor
import com.example.diaryapp.ui.theme.DepressedColor
import com.example.diaryapp.ui.theme.DisappointedColor
import com.example.diaryapp.ui.theme.HappyColor
import com.example.diaryapp.ui.theme.HumorousColor
import com.example.diaryapp.ui.theme.LonelyColor
import com.example.diaryapp.ui.theme.MysteriousColor
import com.example.diaryapp.ui.theme.NeutralColor
import com.example.diaryapp.ui.theme.RomanticColor
import com.example.diaryapp.ui.theme.ShamefulColor
import com.example.diaryapp.ui.theme.SurprisedColor
import com.example.diaryapp.ui.theme.SuspiciousColor
import com.example.diaryapp.ui.theme.TenseColor

enum class Mood(
    val icon: Int,
    val contentColor: Color,
    val containerColor: Color
) {
    Neutral(
        icon = R.drawable.neutral,
        contentColor = Color.Black,
        containerColor = NeutralColor
    ),
    Happy(
        icon = R.drawable.happy,
        contentColor = Color.Black,
        containerColor = HappyColor
    ),
    Angry(
        icon = R.drawable.angry,
        contentColor = Color.White,
        containerColor = AngryColor
    ),
    Bored(
        icon = R.drawable.bored,
        contentColor = Color.Black,
        containerColor = BoredColor
    ),
    Calm(
        icon = R.drawable.calm,
        contentColor = Color.Black,
        containerColor = CalmColor
    ),
    Depressed(
        icon = R.drawable.depressed,
        contentColor = Color.Black,
        containerColor = DepressedColor
    ),
    Disappointed(
        icon = R.drawable.disappointed,
        contentColor = Color.White,
        containerColor = DisappointedColor
    ),
    Humorous(
        icon = R.drawable.humorous,
        contentColor = Color.Black,
        containerColor = HumorousColor
    ),
    Lonely(
        icon = R.drawable.lonely,
        contentColor = Color.White,
        containerColor = LonelyColor
    ),
    Mysterious(
        icon = R.drawable.mysterious,
        contentColor = Color.Black,
        containerColor = MysteriousColor
    ),
    Romantic(
        icon = R.drawable.romantic,
        contentColor = Color.White,
        containerColor = RomanticColor
    ),
    Shameful(
        icon = R.drawable.shameful,
        contentColor = Color.White,
        containerColor = ShamefulColor
    ),
    Awful(
        icon = R.drawable.awful,
        contentColor = Color.Black,
        containerColor = AwfulColor
    ),
    Surprised(
        icon = R.drawable.surprised,
        contentColor = Color.Black,
        containerColor = SurprisedColor
    ),
    Suspicious(
        icon = R.drawable.suspicious,
        contentColor = Color.Black,
        containerColor = SuspiciousColor
    ),
    Tense(
        icon = R.drawable.tense,
        contentColor = Color.Black,
        containerColor = TenseColor
    )
}