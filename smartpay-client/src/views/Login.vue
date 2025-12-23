<script setup>
import Button from '@/components/Button.vue'
import { useVuelidate } from '@vuelidate/core'
import { reactive } from 'vue'
import { email, helpers, minLength, required } from '@vuelidate/validators'

const state = reactive({
  email: '',
  password: '',
})

const sqlKeywords = [
  'SELECT', 'INSERT', 'UPDATE', 'DELETE', 'DROP', 'ALTER', 
  'CREATE', 'TRUNCATE', 'EXEC', 'UNION', '--','JOIN', ';'
]

const noSQLKeywords = helpers.withMessage(
  'Not allowed value in field',
  value => {
    if (!value) return true 
    const upperValue = value.toUpperCase()
    return !sqlKeywords.some(keyword => upperValue.includes(keyword))
  }
)

const rules = {
  email: {
    email: helpers.withMessage("Please enter valid email format",email),
    required: helpers.withMessage("Email is required to access dashboard",required),
      noSQL: noSQLKeywords 
  },
  password: {required: helpers.withMessage("Password is required to access dashboard",required),
            minLength: helpers.withMessage("Password must be 8 char long",minLength(8)),
              noSQL: noSQLKeywords 
  },
}
const v$ = useVuelidate(rules, state)

const formSubmit = async () => {
  const isValid = await v$.value.$validate()
  if (!isValid) {
    return
  }

  console.log('Form submitted:', state)
}
</script>

<template>
  <div class="mx-30 my-10 mb-10 mr-10">
    <div>
      <h1 class="text-white text-4xl font-bold">Welcome back,</h1>
      <p class="text-gray-400 mt-2">Login to make  transaction</p>
    </div>

    <div class="mt-7 text-gray-200">
      <form @submit.prevent="formSubmit">
        <div :class="{ error: v$.email.$errors.length }">
          <p class="">Email address</p>
          <input
            v-model="state.email"
            class="bg-gray-600 rounded w-100 h-10 flex text-center pb-1 outline-none"
            type=" email"
            placeholder="Enter your email address"
          />
          <div v-for="error of v$.email.$errors" :key="error.$uid">
            <p class="text-red-500">{{ error.$message }}</p>
          </div>
        </div>

        <div :class="{error: v$.password.$errors.length}">
          <p class="pt-2">Password</p>
          <input
            v-model="state.password"
            class="bg-gray-600 rounded w-100 h-10 flex text-center pb-1 outline-none"
            type=" text"
            placeholder="Enter your password"
          />
          <div v-for="error of v$.password.$errors" :key="error.$uid">
            <p class="text-red-500">{{ error.$message }}</p>
          </div>
        </div>

        <div class="mt-7">
          <Button class="py-5">
            <p class="w-100">Login</p>
          </Button>
        </div>
      </form>
      <div class="flex">
        <div class="w-45 border border-gray-400 h-0.5 my-3"></div>
        <div class="mr-3 ml-3">
          <p class="text-gray-200 font-light">Or</p>
        </div>
        <div class="w-45 border border-gray-400 h-0.5 my-3"></div>
      </div>

      <div class="mt-7 flex justify-center gap-1">
        <p class="text-gray-400">Don't have an account?</p>
        <p class="text-blue-500 underline"><router-link to="/account-creation">Signup</router-link></p>
      </div>
    </div>
  </div>
</template>
