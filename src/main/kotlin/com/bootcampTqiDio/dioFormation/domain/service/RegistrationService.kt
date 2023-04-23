package com.bootcampTqiDio.dioFormation.domain.service

import com.bootcampTqiDio.dioFormation.domain.entity.Training
import com.bootcampTqiDio.dioFormation.domain.entity.User
import com.bootcampTqiDio.dioFormation.domain.exception.EnrolledUserException
import com.bootcampTqiDio.dioFormation.domain.exception.UserSubscribedListException

class RegistrationService {

    private val subscribed = mutableListOf<User>()

    fun enroll(user: User, training: Training) {

        if (subscribed.contains(user)) {
            throw EnrolledUserException("User ${user.name} already enrolled.");
        } else {
            val mensagem = "User ${user.name} enrolled in training: \n" +
                    " ${training.name} - (${training.level}). \n"       +
                    " Content: ${training.content}"

            subscribed.add(user)
            println(mensagem)
        }
    }

    fun getAllUserSubscribed() {
        if (!subscribed.isEmpty()) {
            println("List of User\n $subscribed")
        } else {
            throw UserSubscribedListException("There are no registered users");
        }
    }
}