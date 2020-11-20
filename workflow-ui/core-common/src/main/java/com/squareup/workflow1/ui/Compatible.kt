package com.squareup.workflow1.ui

/**
 * Normally returns true if [me] and [you] are instances of the same class.
 * If that common class implements [Compatible], both instances must also
 * have the same [Compatible.compatibilityKey].
 *
 * A convenient way to take control over the matching behavior of objects that
 * don't implement [Compatible] is to wrap them with [Named].
 */
@WorkflowUiExperimentalApi
fun compatible(
  me: Any,
  you: Any
): Boolean {
  return when {
    me::class != you::class -> false
    me !is Compatible -> true
    else -> me.compatibilityKey == (you as Compatible).compatibilityKey
  }
}

/**
 * Implemented by objects whose [compatibility][compatible] requires more nuance
 * than just being of the same type.
 *
 * Renderings that don't implement this interface directly can be distinguished
 * by wrapping them with [Named].
 */
@WorkflowUiExperimentalApi
interface Compatible {
  /**
   * Instances of the same type are [compatible] iff they have the same [compatibilityKey].
   */
  val compatibilityKey: String
}
