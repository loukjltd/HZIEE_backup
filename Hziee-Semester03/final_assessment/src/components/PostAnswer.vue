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
						<p class="postQuestionMainTitle" style="padding-top: 40px">回答问题</p>
						<p id="answerDetailOfficialTitle" style="margin-left: 18px;margin-top: -36px">{{ queryParams.qTitle }}</p>
						<p id="answerDetailOfficialContent" style="margin-left: 18px; margin-right: 18px">{{ queryParams.qContent
						                                                                                  }}</p>
						<div class="postMainContent">
							<form v-for="item in creatorData" v-bind:key="item" name="commentPart">
								<a class="contentLikeNumber" href="#" v-on:click="doAddEnterTextToTextArea()">插入换行符号</a>
								<a class="contentLikeNumber" href="#" v-on:click="doAddSingleLineToTextArea()">插入分割线</a>
								<textarea v-model="enteredAnswerContent" class="enterPostContent"
								          name="commentArea" placeholder="在这里写下你对这个问题的解答吧～"></textarea>
								<br>
								<input class="enterButton" type="button" value="提交回答"
								       v-on:click="doInsertAnswerToDatabase(item.uID)">
							</form>
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
import {
	DoInsertAnswerToDatabase,
	DoLoadLoggedUserInfoInCreatorCenter,
	DoTaskUpdatePostDetailTimes
} from "@/utility/api";

export default {
	/* eslint-disable*/
	name: "PostAnswer",
	data() {
		return {
			queryParams: {},
			creatorData: [],
			enteredAnswerContent: "",
			returnedPostAnswerResultCode: 0,
			enteredSearchContent: ""
		}
	},
	methods: {
		doLoadLoggedUserInfoInCreatorCenter: function () {
			DoLoadLoggedUserInfoInCreatorCenter().then(res => {
				this.creatorData = res;
			});
		},
		
		doInsertAnswerToDatabase: function (uID) {
			let testParams = {
				aContent: this.enteredAnswerContent,
				qID: this.queryParams.qID,
				uID: uID
			}
			DoInsertAnswerToDatabase(testParams).then(res => {
				this.returnedPostAnswerResultCode = res;
				switch (this.returnedPostAnswerResultCode) {
					case 100:
						let testParams2 = {
							uID: this.creatorData[0].uID
						};
						DoTaskUpdatePostDetailTimes(testParams2);
						alert("提交问题成功！");
						this.$router.push("/Question");
				}
			})
		},
		
		doAddEnterTextToTextArea: function () {
			const text = "<br>";
			document.forms[0].commentArea.value += text;
		},
		
		doAddSingleLineToTextArea: function () {
			const text = "----------------------------------------";
			document.forms[0].commentArea.value += text;
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
	},
	created() {
		this.queryParams = {
			uID: this.$route.query.uID,
			qID: this.$route.query.qID,
			qTitle: this.$route.query.qTitle,
			qContent: this.$route.query.qContent
		}
	},
	
}
</script>

<style scoped>
@import "../css/Main.css";
@import "../css/Answer.css";
@import "../css/Question.css";
</style>