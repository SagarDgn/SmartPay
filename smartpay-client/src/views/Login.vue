<script setup>
import Button from '@/components/Button.vue';
</script>

<template>
    <div class="mx-30 my-10 mb-10 mr-10 ">
        <div>
             <h1 class="text-white text-4xl font-bold">Welcome back,</h1>
             <p class="text-gray-400 mt-2">Login to access your dashboard</p>
        </div>

        <div class="mt-7 text-gray-200">
            <form>
                <p class="">Email address</p>
                <input class="bg-gray-600 rounded w-100 h-10 flex  text-center pb-1 outline-none" type=" text" placeholder="Enter your email address"/>

                <p class=" pt-2">Password</p>
                 <input class="bg-gray-600 rounded w-100 h-10 flex  text-center pb-1 outline-none" type=" text" placeholder="Enter your password"/>

                 <div class="mt-7">
                    <Button class="py-5" >
                        <p class="w-100">Login</p>
                    </Button>
                 </div>

                 <div  class="flex">
                    <div class="w-45 border border-gray-400 h-0.5 my-3"></div>
                    <div class=" mr-3 ml-3">
                        <p class="text-gray-200 font-light">Or</p>
                    </div>
                    <div class="w-45 border border-gray-400 h-0.5 my-3"></div>

                 </div>

                 
            </form>
        </div>
    </div>
</template>