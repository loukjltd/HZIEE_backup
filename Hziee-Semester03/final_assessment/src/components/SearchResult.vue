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
					<div id="searchResultContent">
						<p class="searchResultMainTitle">搜索结果</p>
						<div v-for="pItem in searchResultParagraph" id="searchResultParagraph" v-bind:key="pItem">
							<a class="contentCategory">专</a>
							<a class="contentTitle"
							   href="#" v-on:click="doSaveClickedParagraph(pItem.uID, pItem.pID)"><b>&nbsp;{{ pItem.pTitle
							                                                                         }}</b></a>
							<br>
							<img alt="找不到图片" v-bind:src="require('@/assets/avatar/' + pItem.uAvatar)">
							<a class="contentNickName">&nbsp;{{ pItem.uNickName }}&nbsp;</a>
							<a class="contentMotto">&nbsp;{{ pItem.uMotto }}</a>
							<br>
							<a v-if="(pItem.pContent).length < 100" class="contentInfo">{{ pItem.pContent }}</a>
							<a v-else class="contentInfo">{{ (pItem.pContent).substring(0, 100) }}... ...</a>
							<br>
							<a class="contentLikeNumber" href="#">▲&nbsp;赞同&nbsp;{{ pItem.pLike }}</a>
							<a class="contentLikeNumber" href="#">反对</a>
							<a class="contentLikeNumber" href="#"
							   v-on:click="doSaveClickedParagraph(pItem.uID, pItem.pID)">阅读全文</a>
							<p style="text-align: center; color: #DAE9FC; margin-top: 15px">
								————————————————————————————————————————</p>
						</div>
						<div v-for="qItem in searchResultQuestion" id="searchResultQuestion" v-bind:key="qItem">
							<a class="contentCategory">问</a>
							<a class="contentTitle" href="#"
							   v-on:click="doSaveClickedQuestion(qItem.uID, qItem.qID)"><b>&nbsp;{{ qItem.qTitle }}</b></a>
							<br>
							<img alt="找不到图片" v-bind:src="require('@/assets/avatar/' + qItem.uAvatar)">
							<a class="contentNickName">&nbsp;{{ qItem.uNickName }}&nbsp;</a>
							<a class="contentMotto">&nbsp;{{ qItem.uMotto }}</a>
							<br>
							<a v-if="(qItem.qContent).length < 100" class="contentInfo">{{ qItem.qContent }}</a>
							<a v-else class="contentInfo">{{ (qItem.qContent).substring(0, 100) }}... ...</a>
							<br>
							<a class="contentLikeNumber" href="#"
							   v-on:click="doSaveClickedQuestionPost(qItem.uID, qItem.qID, qItem.qTitle, qItem.qContent)">🙋我要回答这个问题</a>
							<a class="contentLikeNumber" href="#"
							   v-on:click="doSaveClickedQuestion(qItem.uID, qItem.qID)">阅读全文</a>
							<p style="text-align: center; color: #DAE9FC; margin-top: 15px">
								————————————————————————————————————————</p>
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
	DoLoadLoggedUserInfoInCreatorCenter,
	DoSearchDatabaseAnswer,
	DoSearchDatabaseParagraph,
	DoSearchDatabaseQuestion
} from "@/utility/api";

export default {
	/* eslint-disable*/
	name: "SearchResult",
	data() {
		return {
			creatorData: [],
			queryParams: {},
			searchResultParagraph: [],
			searchResultQuestion: [],
			searchResultAnswer: [],
			enteredSearchContent: ""
		}
	},
	
	methods: {
		doLoadLoggedUserInfoInCreatorCenter: function () {
			DoLoadLoggedUserInfoInCreatorCenter().then(res => {
				this.creatorData = res;
			});
		},
		
		doLoadSearchDatabaseData: function () {
			let testParams = {
				srContent: this.queryParams.srContent
			};
			DoSearchDatabaseParagraph(testParams).then(res => {
				this.searchResultParagraph = res;
			});
			DoSearchDatabaseQuestion(testParams).then(res => {
				this.searchResultQuestion = res;
			});
			DoSearchDatabaseAnswer(testParams).then(res => {
				this.searchResultAnswer = res;
			});
		},
		
		doSaveClickedParagraph: function (uID, pID) {
			this.$router.push({
				path: '/ParagraphSubPage',
				query: {
					uID: uID,
					pID: pID
				}
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
		this.doLoadLoggedUserInfoInCreatorCenter();
		this.doLoadSearchDatabaseData();
	},
	
	created() {
		this.queryParams = {
			srContent: this.$route.query.srContent
		}
	}
}
</script>

<style scoped>
@import "../css/Main.css";
@import "../css/SearchResult.css";
@import "../css/Paragraph.css";
@import "../css/Question.css";
</style>