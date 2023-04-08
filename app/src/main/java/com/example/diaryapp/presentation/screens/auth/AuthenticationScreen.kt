@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.diaryapp.presentation.screens.auth

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.diaryapp.utils.Constants.CLIENT_ID
import com.stevdzasan.messagebar.ContentWithMessageBar
import com.stevdzasan.messagebar.MessageBarState
import com.stevdzasan.onetap.OneTapSignInState
import com.stevdzasan.onetap.OneTapSignInWithGoogle

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AuthenticationScreen(
    loadingState: Boolean,
    oneTapSignInState: OneTapSignInState,
    messageBarState: MessageBarState,
    onButtonClicked: () -> Unit,
    onTokenIdReceived: (String) -> Unit,
    onDialogDismissed: (String) -> Unit
) {
    Scaffold(content = {
        ContentWithMessageBar(messageBarState = messageBarState) {
            AuthenticationContent(
                loadingState, onButtonClicked
            )
        }
    })

    OneTapSignInWithGoogle(
        state = oneTapSignInState,
        clientId = CLIENT_ID,
        onTokenIdReceived = { tokenId ->
            onTokenIdReceived.invoke(tokenId)
        },
        onDialogDismissed = { message ->
            onDialogDismissed.invoke(message)
        }
    )
}