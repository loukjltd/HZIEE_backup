<template>
	<div>
		<div id="navBar">
			<ul>
				<li class="navBarCommonItem">
					<router-link to="/"><a>首页</a></router-link>
				</li>
				<li class="navBarCommonItem">
					<router-link to="/Question"><a>提问</a></router-link>
				</li>
				<li class="navBarCommonItem">
					<router-link to="/Paragraph"><a>专栏</a></router-link>
				</li>
				<li class="navBarCommonItem">
					<router-link to="/Task"><a>任务</a></router-link>
				</li>
				<li class="navBarCommonItem">
					<router-link to="/Notification"><a>通知</a></router-link>
				</li>
				<li>
					<input id="navBarSearchBox" placeholder="请搜索想要搜索的内容" type="search">
					<input id="navBarSearchButton" type="button" value="搜索">
				</li>
				<li class="navBarCommonItem">
					<router-link to="/Creator"><a
							style="color: black; font-weight: bold; border-bottom: #056DE8 solid 5px">创作中心</a></router-link>
				</li>
				<li class="navBarCommonItem">
					<router-link to="/Mine"><a>我的</a></router-link>
				</li>
			</ul>
		</div>
		
		<div id="creatorContent">
			<p class="creatorMainTitle">数据总览</p>
			<p style="margin-left: 55px; margin-bottom: 15px;color: #8590A6; font-size: small">
				注：⇧表示同比增长百分比，⎋表示超过全站其他用户的百分比</p>
			<ul v-for="item in creatorData" v-bind:key="item">
				<li v-if="creatorData != false">
					<p class="creatorTitle">近7日阅读数</p>
					<p class="creatorNumber">12345</p>
					<p class="creatorPercentage">⇧&nbsp;<a class="creatorPercentageSpecify">88</a>%</p>
				</li>
				<li v-if="creatorData != false">
					<p class="creatorTitle">近7日赞同数</p>
					<p class="creatorNumber">23</p>
					<p class="creatorPercentage">⇧&nbsp;<a class="creatorPercentageSpecify">233</a>%</p>
				</li>
				<li v-if="creatorData != false">
					<p class="creatorTitle">近7日评论数</p>
					<p class="creatorNumber">6</p>
					<p class="creatorPercentage">⇧&nbsp;<a class="creatorPercentageSpecify">67</a>%</p>
				</li>
				<li v-if="creatorData != false">
					<p class="creatorTitle">近7日收益（元）</p>
					<p class="creatorNumber">88.88</p>
					<p class="creatorPercentage">⇧&nbsp;<a class="creatorPercentageSpecify">268</a>%</p>
				</li>
				<li v-if="creatorData != false">
					<p class="creatorTitle">总阅读数</p>
					<p class="creatorNumber">{{ item.tRead }}</p>
					<p class="creatorPercentage">⎋&nbsp;<a class="creatorPercentageSpecify">12</a>%</p>
				</li>
				<li v-if="creatorData != false">
					<p class="creatorTitle">总赞同数</p>
					<p class="creatorNumber">{{ item.tLike }}</p>
					<p class="creatorPercentage">⎋&nbsp;<a class="creatorPercentageSpecify">15</a>%</p>
				</li>
				<li v-if="creatorData != false">
					<p class="creatorTitle">总评论数</p>
					<p class="creatorNumber">{{ item.tComment }}</p>
					<p class="creatorPercentage">⎋&nbsp;<a class="creatorPercentageSpecify">1</a>%</p>
				</li>
				<li v-if="creatorData != false">
					<p class="creatorTitle">总收益（元）</p>
					<p class="creatorNumber">{{ item.tCash }}</p>
					<p class="creatorPercentage">⎋&nbsp;<a class="creatorPercentageSpecify">24</a>%</p>
				</li>
			</ul>
			<div v-if="creatorData != false" style="margin-top: 400px">
				<p class="creatorMainTitle">内容创作</p>
				<div style="margin-left: 55px">
					<router-link to="/PostQuestion"><input class="enterButton" name="choosePostQuestion" type="button"
					                                       value="🙋我要提出问题"></router-link>
					<a class="creatorEnterButtonNote">&nbsp;&nbsp;每天提问题，额外奖励分等你来拿</a>
					<br>
					<br>
					<router-link to="/PostParagraph"><input class="enterButton" name="chooseWriteParagraph" type="button"
					                                        value="🙋我要撰写专栏"></router-link>
					<a class="creatorEnterButtonNote">&nbsp;&nbsp;每天写文章，额外奖励分等你来拿</a>
					<br>
					<br>
					<input class="enterButton" name="chooseAnswerQuestion" type="button" value="🙋我要回答问题">
					<a class="creatorEnterButtonNote">&nbsp;&nbsp;每天答问题，额外奖励分等你来拿</a>
				</div>
			
			</div>
			<ul v-if="creatorData == false">
				<br>
				<li>
					<p class="creatorTitle">近7日阅读数</p>
					<p class="creatorNumber">暂无</p>
					<p class="creatorPercentage">请先登录！</p>
				</li>
				<li>
					<p class="creatorTitle">近7日赞同数</p>
					<p class="creatorNumber">暂无</p>
					<p class="creatorPercentage">请先登录！</p>
				</li>
				<li>
					<p class="creatorTitle">近7日评论数</p>
					<p class="creatorNumber">暂无</p>
					<p class="creatorPercentage">请先登录！</p>
				</li>
				<li>
					<p class="creatorTitle">近7日收益（元）</p>
					<p class="creatorNumber">暂无</p>
					<p class="creatorPercentage">请先登录！</p>
				</li>
				<li>
					<p class="creatorTitle">总阅读数</p>
					<p class="creatorNumber">暂无</p>
					<p class="creatorPercentage">请先登录！</p>
				</li>
				<li>
					<p class="creatorTitle">总赞同数</p>
					<p class="creatorNumber">暂无</p>
					<p class="creatorPercentage">请先登录！</p>
				</li>
				<li>
					<p class="creatorTitle">总评论数</p>
					<p class="creatorNumber">暂无</p>
					<p class="creatorPercentage">请先登录！</p>
				</li>
				<li>
					<p class="creatorTitle">总收益（元）</p>
					<p class="creatorNumber">暂无</p>
					<p class="creatorPercentage">请先登录！</p>
				</li>
			</ul>
		</div>
	</div>
</template>

<script>
/* eslint-disable*/
import {DoLoadLoggedUserInfoInCreatorCenter} from "@/utility/api";

export default {
	name: "Creator",
	data() {
		return {
			creatorData: []
		}
	},
	
	methods: {
		doLoadCreator: function () {
			DoLoadLoggedUserInfoInCreatorCenter().then(res => {
				this.creatorData = res;
			});
		},
	},
	
	mounted() {
		this.doLoadCreator();
	}
}
</script>

<style scoped>
@import "../css/Main.css";
@import "../css/Creator.css";
</style>