import Vue from 'vue'
import Router from 'vue-router'
import HomePage from "@/components/HomePage";

Vue.use(Router)
export default new Router({
	routes: [
		{
			path: '/',
			name: 'HomePage',
			component: HomePage
		},
		{
			path: '/Question',
			name: 'Question',
			component: () => import('@/components/Question')
		},
		{
			path: '/Paragraph',
			name: 'Paragraph',
			component: () => import('@/components/Paragraph')
		},
		{
			path: '/Task',
			name: 'Task',
			component: () => import('@/components/Task')
		},
		{
			path: '/Notification',
			name: 'Notification',
			component: () => import('@/components/Notification')
		},
		{
			path: '/Creator',
			name: 'Creator',
			component: () => import('@/components/Creator')
		},
		{
			path: '/Mine',
			name: 'Mine',
			component: () => import('@/components/Mine')
		},
		{
			path: '/PostQuestion',
			name: 'PostQuestion',
			component: () => import('@/components/PostQuestion')
		},
		{
			path: '/PostParagraph',
			name: 'PostParagraph',
			component: () => import('@/components/PostParagraph')
		},
		{
			path: '/ParagraphSubPage',
			name: 'ParagraphSubPage',
			component: () => import('@/components/ParagraphSubPage')
		},
		{
			path: '/QuestionSubPage',
			name: 'QuestionSubPage',
			component: () => import('@/components/QuestionSubPage')
		},
		{
			path: '/AnswerSubPage',
			name: 'AnswerSubPage',
			component: () => import('@/components/AnswerSubPage')
		},
		{
			path: '/AdminManager',
			name: 'AdminManager',
			component: () => import('@/components/AdminManager')
		}
	]
})