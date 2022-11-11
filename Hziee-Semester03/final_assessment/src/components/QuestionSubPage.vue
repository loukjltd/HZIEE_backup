<template>
	<div>
		<div id="navBar">
			<ul>
				<li class="navBarCommonItem">
					<router-link to="/"><a>首页</a>
					</router-link>
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
						<div v-for="item in questionData" id="questionOfficialContent" v-bind:key="item">
							<p id="questionOfficialTitle">{{ item.qTitle }}</p>
							<br>
							<img id="questionOfficialAvatar" alt="找不到图片" v-bind:src="require('@/assets/avatar/' + item.uAvatar)">
							<a id="questionOfficialNickName">&nbsp;{{ item.uNickName }}</a>
							<a id="questionOfficialMotto">&nbsp;{{ item.uMotto }}</a>
							<p id="questionOfficialContent">{{ item.qContent }}</p>
							<a class="contentLikeNumber" href="#" style="margin-left: 35px">🙋我要回答这个问题</a>
							<br>
							<p id="questionOfficialLikeNumber">以下是此问题的回答</p>
							<br>
							<div v-for="aItem in answerData" v-bind:key="aItem">
								<img id="answerOfficialAvatar" alt="找不到图片"
								     v-bind:src="require('@/assets/avatar/' + aItem.uAvatar)">
								<a class="answerOfficialNickName">&nbsp;{{ aItem.uNickName }}&nbsp;</a>
								<a class="answerOfficialMotto">&nbsp;{{ aItem.uMotto }}</a>
								<br>
								<p v-if="(aItem.aContent).length < 100" id="questionOfficialContent">{{ aItem.aContent }}</p>
								<p v-else id="questionOfficialContent">{{ (aItem.aContent).substring(0, 100) }}... ...</p>
								<a class="contentLikeNumber" href="#" style="margin-left: 35px">▲&nbsp;赞同&nbsp;{{ aItem.aLike }}</a>
								<a class="contentLikeNumber" href="#">反对</a>
								<a class="contentLikeNumber" href="#">评论</a>
								<a class="contentLikeNumber" href="#"
								   v-on:click="doSaveClickedAnswer(aItem.uID, aItem.qID, aItem.aID, item.qTitle)">阅读全文</a>
								<p style="text-align: center; color: #DAE9FC; margin-top: 15px">
									————————————————————————————————————————</p>
							</div>
						</div>
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
import {DoLoadLoggedUserInfoInCreatorCenter, DoViewQuestionAnswerList, DoViewQuestionList} from "@/utility/api";

export default {
	/* eslint-disable*/
	name: "QuestionSubPage",
	data() {
		return {
			queryParams: {},
			creatorData: [],
			questionData: [],
			answerData: [],
			commentFlag: false,
			enteredSearchContent: ""
		}
	},
	
	methods: {
		doLoadLoggedUserInfoInCreatorCenter: function () {
			DoLoadLoggedUserInfoInCreatorCenter().then(res => {
				this.creatorData = res;
			});
		},
		
		doViewQuestionList: function () {
			let testParams = this.queryParams;
			DoViewQuestionList(testParams).then(res => {
				this.questionData = res;
			});
		},
		
		doViewQuestionAnswerList: function () {
			let testParams = this.queryParams;
			DoViewQuestionAnswerList(testParams).then(res => {
				console.log(res);
				this.answerData = res;
			});
		},
		
		doSaveClickedAnswer: function (uID, qID, aID, qTitle) {
			this.$router.push({
				path: '/AnswerSubPage',
				query: {
					uID: uID,
					qID: qID,
					aID: aID,
					qTitle: qTitle
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
		this.doLoadLoggedUserInfoInCreatorCenter();
		this.doViewQuestionList();
		this.doViewQuestionAnswerList();
	},
	
	created() {
		this.queryParams = {
			uID: this.$route.query.uID,
			qID: this.$route.query.qID
		}
	}
}
</script>

<style scoped>
@import "../css/Main.css";
@import "../css/Question.css";
@import "../css/Answer.css";
</style>