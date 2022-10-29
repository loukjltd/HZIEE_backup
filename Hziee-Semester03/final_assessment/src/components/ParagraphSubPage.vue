<template>
	<div>
		<div id="navBar">
			<ul>
				<li class="navBarCommonItem">
					<router-link to="/"><a>首页</a>
					</router-link>
				</li>
				<li class="navBarCommonItem">
					<router-link to="/Question"><a>提问</a></router-link>
				</li>
				<li class="navBarCommonItem">
					<router-link to="/Paragraph"><a
							style="color: black; font-weight: bold; border-bottom: #056DE8 solid 5px">专栏</a></router-link>
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
					<router-link to="/Creator"><a>创作中心</a></router-link>
				</li>
				<li class="navBarCommonItem">
					<router-link to="/Mine"><a>我的</a></router-link>
				</li>
			</ul>
		</div>
		
		<div id="pageLayoutList">
			<ul>
				<li>
					<div id="paragraphContent">
						<div v-for="item in paragraphData" id="paragraphOfficialContent" v-bind:key="item">
							<p id="paragraphOfficialTitle">{{ item.pTitle }}</p>
							<br>
							<img id="paragraphOfficialAvatar" alt="找不到图片"
							     v-bind:src="require('@/assets/avatar/' + item.uAvatar)">
							<a id="paragraphOfficialNickName">&nbsp;{{ item.uNickName }}&nbsp;</a>
							<a id="paragraphOfficialMotto">&nbsp;{{ item.uMotto }}</a>
							<p id="paragraphOfficialLikeNumber">有{{ item.pLike }}人点赞了此文章</p>
							<p v-for="content in item.pContent.split('<br>')" id="paragraphOfficialContent" v-bind:key="content">
								{{ content }}</p>
							<br>
							<a class="contentLikeNumber" href="#" style="margin-left: 30px">▲&nbsp;赞同&nbsp;{{ item.pLike }}</a>
							<a class="contentLikeNumber" href="#">反对</a>
							<a class="contentLikeNumber" href="#" v-on:click="doChooseComment(commentFlag)">评论</a>
							<br>
						</div>
						
						<form v-if="this.commentFlag">
							<textarea id="paragraphOfficialComment" placeholder="评论千万条，友善第一条"
							          style="margin-top: 10px;"></textarea>
							<input class="enterButton" style="margin-left: 65px; margin-top: -20px;" type="button" value="发表评论">
						</form>
						<div id="bottomLine">
							<br><br><br>
							<p>-&nbsp;&nbsp;到底啦&nbsp;&nbsp;-</p>
						</div>
					</div>
				</li>
				
				<li>
					<div v-for="item in creatorData" id="homePageSecondContent" v-bind:key="item">
						<br>
						<a id="creatorCenterTitle">创作中心</a>
						<br>
						<img alt="找不到图片" v-bind:src="require('@/assets/avatar/' + item.uAvatar)">
						<br>
						<a id="creatorCenterSecondContent">{{ item.uNickName }}</a>
						<br>
						<br>
						<ul id="activityButton">
							<li>
								<img src="../assets/system/Answer.png">
								<p>回答问题</p>
							</li>
							<li>
								<img src="../assets/system/Question.png">
								<p>提出问题</p>
							</li>
							<li>
								<img src="../assets/system/Paragraph.png">
								<p>写文章</p>
							</li>
							<li>
								<img src="../assets/system/Task.png">
								<p>做任务</p>
							</li>
						</ul>
						<br>
						<ul id="bigDataNumber">
							<li>
								<p class="bigDataTitle">阅读数</p>
								<p class="bigDataContent">{{ item.tRead }}</p>
							</li>
							<li>
								<p class="bigDataTitle">点赞数</p>
								<p class="bigDataContent">{{ item.tLike }}</p>
							</li>
							<li>
								<p class="bigDataTitle">金币数</p>
								<p class="bigDataContent">{{ item.tCoin }}</p>
							</li>
						</ul>
						<br>
						<div id="enterCreatorCenter">
							<router-link to="/Creator"><a>进入创作中心 ></a></router-link>
						</div>
					</div>
					<div v-if="creatorData == false" id="homePageSecondContent">
						<br>
						<a id="creatorCenterTitle">创作中心</a>
						<br>
						<img alt="找不到图片" src="../assets/avatar/avataaars-10.png">
						<br>
						<a id="creatorCenterSecondContent">请先登陆！</a>
						<br>
						<br>
						<ul id="activityButton">
							<li>
								<img src="../assets/system/Answer.png">
								<p>回答问题</p>
							</li>
							<li>
								<img src="../assets/system/Question.png">
								<p>提出问题</p>
							</li>
							<li>
								<img src="../assets/system/Paragraph.png">
								<p>写文章</p>
							</li>
							<li>
								<img src="../assets/system/Task.png">
								<p>做任务</p>
							</li>
						</ul>
						<br>
						<ul id="bigDataNumber">
							<li>
								<p class="bigDataTitle">阅读数</p>
								<p class="bigDataContent">暂无</p>
							</li>
							<li>
								<p class="bigDataTitle">点赞数</p>
								<p class="bigDataContent">暂无</p>
							</li>
							<li>
								<p class="bigDataTitle">金币数</p>
								<p class="bigDataContent">暂无</p>
							</li>
						</ul>
						<br>
						<div id="enterCreatorCenter">
							<router-link to="/Mine"><a>进入登陆页面 ></a></router-link>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</div>
</template>

<script>
import {DoLoadLoggedUserInfoInCreatorCenter, DoViewParagraphDetail} from "@/utility/api";

export default {
	/* eslint-disable*/
	name: "ParagraphSubPage",
	data() {
		return {
			queryParams: {},
			creatorData: [],
			paragraphData: [],
			commentFlag: false
		}
	},
	
	methods: {
		doLoadLoggedUserInfoInCreatorCenter: function () {
			DoLoadLoggedUserInfoInCreatorCenter().then(res => {
				this.creatorData = res;
			});
		},
		
		doViewParagraphDetail: function () {
			let testParams = this.queryParams;
			console.log(testParams);
			DoViewParagraphDetail(testParams).then(res => {
				this.paragraphData = res;
			});
		},
		
		doChooseComment: function (commentFlag) {
			this.commentFlag = !commentFlag;
		},
	},
	
	mounted() {
		this.doLoadLoggedUserInfoInCreatorCenter();
		this.doViewParagraphDetail();
	},
	
	created() {
		this.queryParams = {
			uID: this.$route.query.uID,
			pTitle: this.$route.query.pTitle
		}
	}
}
</script>

<style scoped>
@import "../css/Main.css";
@import "../css/Paragraph.css";
</style>