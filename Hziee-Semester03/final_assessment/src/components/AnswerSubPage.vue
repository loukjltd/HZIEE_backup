<template>
	<div>
		<div id="navBar">
			<ul>
				<li class="navBarCommonItem">
					<router-link to="/"><a>首页</a>
					</router-link>
				</li>
				<li class="navBarCommonItem">
					<router-link to="/Question">
						<a style="color: black; font-weight: bold; border-bottom: #056DE8 solid 5px">提问</a></router-link>
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
					<div id="answerDetailContent">
						<div v-for="item in answerData" id="answerDetailOfficialContent" v-bind:key="item">
							<p id="answerDetailOfficialTitle">{{ queryParams.qTitle }}</p>
							<br>
							<img id="answerDetailOfficialAvatar" alt="找不到图片"
							     v-bind:src="require('@/assets/avatar/' + item.uAvatar)">
							<a id="answerDetailOfficialNickName">&nbsp;{{ item.uNickName }}&nbsp;</a>
							<a id="answerDetailOfficialMotto">&nbsp;{{ item.uMotto }}</a>
							<p id="answerDetailOfficialLikeNumber">有{{ item.aLike }}人点赞了此回答</p>
							<p v-for="content in item.aContent.split('<br>')" id="answerDetailOfficialContent" v-bind:key="content">
								{{ content }}</p>
							<a class="contentLikeNumber" href="#" style="margin-left: 30px">▲&nbsp;赞同&nbsp;{{ item.aLike }}</a>
							<a class="contentLikeNumber" href="#">反对</a>
							<a class="contentLikeNumber" href="#" v-on:click="doChooseComment(commentFlag)">评论</a>
							<a class="contentLikeNumber" href="#" v-on:click="doChooseThisAnswerAsBestAnswer(item.aID)">采纳</a>
							<br>
							<p id="answerDetailOfficialLikeNumber">以下是此回答的评论</p>
							<br>
						</div>
						
						<form v-if="this.commentFlag">
							<textarea id="answerDetailOfficialComment" v-model="enteredAnswerCommentContent"
							          placeholder="评论千万条，友善第一条" style="margin-top: 10px;"></textarea>
							<input v-for="uID in creatorData" v-bind:key="uID" class="enterButton"
							       style="margin-left: 65px; margin-top: -20px;"
							       type="button" value="发表评论"
							       v-on:click="doInsertNewCommentToDatabase2(uID.uID)">
						</form>
						
						<div v-for="item in answerCommentData" v-bind:key="item" class="commentPart">
							<img alt="找不到图片" class="commentAvatar" v-bind:src="require('@/assets/avatar/' + item.uAvatar)">
							<a class="commentNickName">{{ item.uNickName }}</a>
							<br>
							<a class="commentContent">{{ item.acContent }}</a>
							<br>
							<a class="commentLikeNumber" href="#">▲&nbsp;{{ item.acLike }}</a>
							<br>
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
import {
	DoChooseThisAnswerAsBestAnswer,
	DoInsertNewCommentToDatabase2,
	DoLoadAnswerCommentData,
	DoLoadLoggedUserInfoInCreatorCenter,
	DoLoadViewAnswerDetail,
	DoTaskUpdateReadDetailTimes
} from "@/utility/api";

export default {
	/* eslint-disable*/
	name: "AnswerSubPage",
	data() {
		return {
			creatorData: [],
			queryParams: {},
			answerData: [],
			commentFlag: false,
			answerCommentData: [],
			enteredAnswerCommentContent: "",
			enteredSearchContent: "",
			returnedChooseThisAnswerAsBestAnswerResultCode: 0,
			checkIfHaveBestAnswer: false,
		}
	},
	
	methods: {
		doLoadLoggedUserInfoInCreatorCenter: function () {
			DoLoadLoggedUserInfoInCreatorCenter().then(res => {
				this.creatorData = res;
			});
		},
		
		doLoadViewAnswerDetail: function () {
			let testParams = this.queryParams;
			DoLoadViewAnswerDetail(testParams).then(res => {
				this.answerData = res;
			});
		},
		
		doChooseComment: function (commentFlag) {
			this.commentFlag = !commentFlag;
		},
		
		doLoadAnswerCommentData: function () {
			let testParams = this.queryParams;
			DoLoadAnswerCommentData(testParams).then(res => {
				this.answerCommentData = res;
			})
		},
		
		doInsertNewCommentToDatabase2: function (uID) {
			let currentTime = new Date();
			let testParams = {
				aID: this.queryParams.aID,
				qID: this.queryParams.qID,
				uID: uID,
				acContent: this.enteredAnswerCommentContent,
				acTime: currentTime.toLocaleString()
			}
			DoInsertNewCommentToDatabase2(testParams).then(res => {
				this.returnedPostAnswerCommentResultCode = res;
				switch (this.returnedPostAnswerCommentResultCode) {
					case 100:
						alert("评论成功！")
				}
			});
		},
		
		doCalculateReadTimes: function () {
			clearTimeout(this.readTimesTimer);
			this.readTimesTimer = setTimeout(() => {
				this.doTaskUpdateReadDetailTimes()
			}, 1000)
		},
		
		doTaskUpdateReadDetailTimes: function () {
			let testParams = {
				uID: this.creatorData[0].uID
			}
			DoTaskUpdateReadDetailTimes(testParams);
		},
		
		doSearchDatabase: function () {
			this.$router.push({
				path: '/SearchResult',
				query: {
					srContent: this.enteredSearchContent
				}
			})
		},
		
		doChooseThisAnswerAsBestAnswer: function (aID) {
			let testParams = {
				qID: this.$route.query.qID,
				aID: aID,
				answerPosterID: this.$route.query.uID
			}
			console.log(testParams.qID);
			DoChooseThisAnswerAsBestAnswer(testParams).then(res => {
				this.returnedChooseThisAnswerAsBestAnswerResultCode = res;
				switch (this.returnedChooseThisAnswerAsBestAnswerResultCode) {
					case 100:
						alert("已采纳此回答为本提问最佳回答！");
						break;
					case 122:
						alert("您已经选择过最最佳回答了！");
						break;
					case 144:
						alert("您不是该问题的提问者，无法选择最佳答案！");
						break;
				}
			})
		},
	},
	
	mounted() {
		this.doLoadLoggedUserInfoInCreatorCenter();
		this.doLoadViewAnswerDetail();
		this.doLoadAnswerCommentData();
		this.doCalculateReadTimes();
	},
	
	created() {
		this.queryParams = {
			uID: this.$route.query.uID,
			qID: this.$route.query.qID,
			aID: this.$route.query.aID,
			qTitle: this.$route.query.qTitle,
			questionPoster: this.$route.query.questionPoster,
		}
	}
}
</script>

<style scoped>
@import "../css/Main.css";
@import "../css/Answer.css";
</style>