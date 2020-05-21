/*
 * Copyright 2020 Square Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.sample.launcher

import androidx.activity.ComponentActivity
import com.squareup.sample.hellocompose.HelloComposeActivity
import com.squareup.sample.hellocomposebinding.HelloBindingActivity
import com.squareup.sample.hellocomposerendering.HelloComposeRenderingActivity
import com.squareup.sample.nestedrenderings.NestedRenderingsActivity
import kotlin.reflect.KClass

val samples = listOf(
    Sample(
        "Hello Compose Binding", HelloBindingActivity::class,
        "Creates a ViewFactory using bindCompose."
    ),
    Sample(
        "Hello Compose Rendering", HelloComposeRenderingActivity::class,
        "Uses ComposeWorkflow to create a workflow that draws itself."
    ),
    Sample(
        "Hello Compose", HelloComposeActivity::class,
        "A pure Compose app that launches its root Workflow from inside Compose."
    ),
    Sample(
        "Nested Renderings", NestedRenderingsActivity::class,
        "Demonstrates recursive view factories using both Compose and legacy view factories."
    )
)

data class Sample(
  val name: String,
  val activityClass: KClass<out ComponentActivity>,
  val description: String
)
