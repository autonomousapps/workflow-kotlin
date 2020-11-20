package com.squareup.workflow1.ui.modal

import com.squareup.workflow1.ui.WorkflowUiExperimentalApi

/**
 * Models a typical "You sure about that?" alert box.
 */
@WorkflowUiExperimentalApi
data class AlertScreen(
  val buttons: Map<Button, String> = emptyMap(),
  val message: String = "",
  val title: String = "",
  val cancelable: Boolean = true,
  val onEvent: (Event) -> Unit
) {
  enum class Button {
    POSITIVE,
    NEGATIVE,
    NEUTRAL
  }

  sealed class Event {
    data class ButtonClicked(val button: Button) : Event()

    object Canceled : Event()
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as AlertScreen

    return buttons == other.buttons &&
        message == other.message &&
        title == other.title &&
        cancelable == other.cancelable
  }

  override fun hashCode(): Int {
    var result = buttons.hashCode()
    result = 31 * result + message.hashCode()
    result = 31 * result + title.hashCode()
    result = 31 * result + cancelable.hashCode()
    return result
  }
}
