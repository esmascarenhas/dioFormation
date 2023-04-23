package com.bootcampTqiDio.dioFormation

import com.bootcampTqiDio.dioFormation.domain.entity.EducationalContent
import com.bootcampTqiDio.dioFormation.domain.entity.Level
import com.bootcampTqiDio.dioFormation.domain.entity.Training
import com.bootcampTqiDio.dioFormation.domain.entity.User
import com.bootcampTqiDio.dioFormation.domain.exception.EnrolledUserException
import com.bootcampTqiDio.dioFormation.domain.exception.UserSubscribedListException
import com.bootcampTqiDio.dioFormation.domain.service.RegistrationService
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class DioFormationApplication

fun main() {

	//user registration
	val user = User("Emerson", "esm@email.com")
	val user2 = User("Tiago","tiago@email.com")
	val user3 = User("Josi","josi@email.com")
	val user4 = User("Sonia","sonia@email.com")

	//content registration
	val content = EducationalContent("kotlin training",240)
	val content1 = EducationalContent("Essential docker",320)
	val content2 = EducationalContent("Java training",240)
	val content3 = EducationalContent("Mastering SQL",180)


	//Training Registration
	val trainingJava = Training("Java Backend", listOf(content1,content2,content3),Level.INTERMEDIARIO)
	val trainingKotlin = Training("Kotlin Backend", listOf(content1,content2,content3),Level.INTERMEDIARIO)

	//registration
	val registration = RegistrationService()

	try {
		registration.enroll(user, trainingKotlin)
		registration.enroll(user2, trainingKotlin)
		registration.enroll(user3, trainingJava)
		registration.enroll(user4, trainingJava)
		registration.getAllUserSubscribed()
		registration.enroll(user2, trainingKotlin)
	} catch (e: UserSubscribedListException) {
		println(e.message)
	} catch (e: EnrolledUserException) {
		println(e.message)
	} finally {
	    "enrollment closed"
	}

}
