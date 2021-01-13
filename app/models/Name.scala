/*
 * Copyright 2021 HM Revenue & Customs
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

package models

import play.api.libs.json._

case class Name(firstName: String, middleName: Option[String], lastName: String) {
  lazy val displayName : String = firstName + " " + lastName

  private val middleNameFormatted = middleName.fold(" ")(m => s" $m ")
  lazy val displayFullName : String = firstName + middleNameFormatted + lastName
}

object Name {
  implicit lazy val formats: Format[Name] = Json.format[Name]
}

