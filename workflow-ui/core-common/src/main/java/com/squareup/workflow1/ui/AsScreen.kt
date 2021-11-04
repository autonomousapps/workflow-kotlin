package com.squareup.workflow1.ui

@WorkflowUiExperimentalApi
public class AsScreen<W : Any>(
  public val rendering: W
) : Screen, Compatible {
  init {
    check(rendering !is Screen) {
      "AsScreen is for converting non-Screen renderings, it should not wrap Screen $rendering."
    }
  }

  override val compatibilityKey: String
    get() = Compatible.keyFor(rendering)

  public companion object {
    /**
     * Transforms [rendering] to implement [Screen], wrapping it in an [AsScreen] if necessary.
     */
    public fun asScreen(rendering: Any): Screen {
      return when (rendering) {
        is Screen -> rendering
        else -> AsScreen(rendering)
      }
    }
  }
}
