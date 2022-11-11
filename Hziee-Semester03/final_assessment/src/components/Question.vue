<template>
	<div>
		<div id="navBar">
			<ul>
				<li class="navBarCommonItem">
					<router-link to="/"><a>首页</a></router-link>
				</li>
				<li class="navBarCommonItem">
					<router-link to="/Question"><a
							style="color: black; font-weight: bold; border-bottom: #056DE8 solid 5px">提问</a></router-link>
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
					<input id="navBarSearchBox" v-model="enteredSearchContent" placeholder="请搜索想要搜索的内容"
					       type="search">
					<input id="navBarSearchButton" type="button" value="搜索" v-on:click="doSearchDatabase()">
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
					<div id="questionContent">
						<ul>
							<li v-for="item in questionData" v-bind:key="item">
								<a class="contentCategory">问</a>
								<a class="contentTitle" href="#"
								   v-on:click="doSaveClickedQuestion(item.uID, item.qID)"><b>&nbsp;{{ item.qTitle }}</b></a>
								<br>
								<img alt="找不到图片" v-bind:src="require('@/assets/avatar/' + item.uAvatar)">
								<a class="contentNickName">&nbsp;{{ item.uNickName }}&nbsp;</a>
								<a class="contentMotto">&nbsp;{{ item.uMotto }}</a>
								<br>
								<br>
								<a v-if="(item.qContent).length < 100" class="contentInfo">{{ item.qContent }}</a>
								<a v-else class="contentInfo">{{ (item.qContent).substring(0, 100) }}... ...</a>
								<br>
								<a class="contentLikeNumber" href="#"
								   v-on:click="doSaveClickedQuestionPost(item.uID, item.qID, item.qTitle, item.qContent)">🙋我要回答这个问题</a>
								<a class="contentLikeNumber" href="#"
								   v-on:click="doSaveClickedQuestion(item.uID, item.qID)">阅读全文</a>
								<p style="text-align: center; color: #DAE9FC; margin-top: 15px">
									————————————————————————————————————————</p>
							</li>
						</ul>
						
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
							<router-link to="/Creator"><a href="#">进入创作中心 ></a></router-link>
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
							<router-link to="/Mine"><a href="#">进入登陆页面 ></a></router-link>
						</div>
					</div>
				</li>
			</ul>
		</div>
	
	
	</div>
</template>

<script>
import {DoLoadLoggedUserInfoInCreatorCenter, DoLoadQuestionData} from "@/utility/api";

/* eslint-disable*/
export default {
	name: "Question",
	data() {
		return {
			questionData: [],
			creatorData: [],
			enteredSearchContent: ""
		}
	},
	
	methods: {
		doLoadQuestion: function () {
			DoLoadQuestionData().then(res => {
				this.questionData = res;
			});
		},
		
		doLoadLoggedUserInfoInCreatorCenter: function () {
			DoLoadLoggedUserInfoInCreatorCenter().then(res => {
				this.creatorData = res;
			});
		},
		
		doSaveClickedQuestion: function (uID, qID) {
			this.$router.push({
				path: '/QuestionSubPage',
				query: {
					uID: uID,
					qID: qID
				}
			})
		},
		
		doSaveClickedQuestionPost: function (uID, qID, qTitle, qContent) {
			this.$router.push({
				path: '/PostAnswer',
				query: {
					uID: uID,
					qID: qID,
					qTitle: qTitle,
					qContent: qContent
				}
			})
		},
		
		doSearchDatabase: function () {
			this.$router.push({
				path: '/SearchResult',
				query: {
					srContent: this.enteredSearchContent
				}
			})
		}
	},
	
	mounted() {
		this.doLoadQuestion();
		this.doLoadLoggedUserInfoInCreatorCenter();
	}
}
</script>

<style scoped>
@import "../css/Main.css";
@import "../css/Question.css";
</style>