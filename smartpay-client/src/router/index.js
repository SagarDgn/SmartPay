import EntryPage from '@/pages/EntryPage.vue';
import AccountCreation from '@/pages/user/AccountCreation.vue';
import { createRouter, createWebHistory } from 'vue-router'

const routes=[
  {path: '/',name: "EntryPage", component: EntryPage},
  {path: '/account-creation', name: 'AccountCreation', component: AccountCreation}
  
];

const router = createRouter({
  history: createWebHistory(),
  routes,
})

export default router
