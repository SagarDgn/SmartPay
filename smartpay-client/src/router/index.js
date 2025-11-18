import EntryPage from '@/pages/EntryPage.vue';
import { createRouter, createWebHistory } from 'vue-router'

const routes=[
  {path: '/',name: "EntryPage", component: EntryPage}
  
];

const router = createRouter({
  history: createWebHistory(),
  routes,
})

export default router
