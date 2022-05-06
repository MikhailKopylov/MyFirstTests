package com.geekbrains.myfirsttests

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class EmailValidatorTest {

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.com"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email..com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@email.com"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null))
    }

    @Test
    fun `emailValidator invalid email no domain returnsFalse`(){
        assertFalse(EmailValidator.isValidEmail("vasya@email."))
    }

    @Test
    fun `emailValidator invalid email double @@ returnsFalse`(){
        assertFalse(EmailValidator.isValidEmail("vasya@@email.com"))
    }

    @Test
    fun `emailValidator invalid email user name with non latin alphabet returnsFalse`(){
        assertFalse(EmailValidator.isValidEmail("vasyaФ@email.com"))
    }

    @Test
    fun `emailValidator invalid email name with non latin alphabet returnsFalse`(){
        assertFalse(EmailValidator.isValidEmail("vasya@emailФ.com"))
    }

    @Test
    fun `emailValidator invalid email domain with non latin alphabet returnsFalse`(){
        assertFalse(EmailValidator.isValidEmail("vasya@email.comФ"))
    }
}
