<script setup>
import EntryBanner from '@/views/EntryBanner.vue'
import Button from '@/components/Button.vue'
</script>
<template>
  <div class="flex gap-20">
    <div>
      <EntryBanner />
    </div>
    <div class="mx-30 my-10">
      <div class="mx-5 mr-15 px-10">
        <h1 class="text-white text-4xl font-bold">Welcome to,</h1>
        <h2 class="text-gray-200 font-semibold text-3xl">SmartPAY</h2>
        <p class="text-gray-400 mt-2">Please fill the form below to become our customer</p>

        <div class="mt-7 text-gray-200">
          <form>
            <div class="flex gap-2">
              <div>
                <p class="">First Name</p>
                <input
                  type="text"
                  name="first_name"
                  placeholder="Enter firstname"
                  class="bg-gray-600 rounded w-47 h-10 text-center pb-1 outline-none flex"
                />
              </div>

              <div>
                <p>Last Name</p>
                <input
                  type="text"
                  placeholder="Enter lastname"
                  class="bg-gray-600 w-50 outline-none pb-1 h-10 rounded text-center flex"
                />
              </div>
            </div>

            <div>
              <p class="pt-2">Email</p>
              <input
                type="email"
                placeholder="Enter email"
                class="bg-gray-600 rounded outline-none pb-1 text-center h-10 w-100"
              />
            </div>

            <!-- <div>
                    <p class="pt-2">Password</p>
                    <input type="passwprd"
                    placeholder="Create a password"
                    class="bg-gray-600 rounded text-center w-100 h-10 outline-none pb-1"/>
                    
                </div> -->

            <div class="mt-7">
              <Button class="py-5">
                <p class="w-100">Go for verification</p>
              </Button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>
