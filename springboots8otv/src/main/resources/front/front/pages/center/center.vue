<template>
	<view class="content">
		<view :style='{"minHeight":"100vh","padding":"260rpx 0 400rpx","borderColor":"#21d5ae","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20221223/47f4db5577fb492886b192809902163b.gif) no-repeat left top / 100% auto,url(http://codegen.caihongy.cn/20221223/ec4debd06eba457ca416dd1e20bdea56.gif) no-repeat left bottom / 100% auto,#192231","borderWidth":"0px 0 0","display":"flex","width":"100%","position":"relative","borderStyle":"dashed","height":"auto"}'>
			<view :style='{"padding":"0px","boxShadow":"inset 0px 0px 0px 0px #f7dcab","margin":"60rpx auto 60rpx","borderColor":"#0bd9ed","display":"flex","justifyContent":"flex-start","borderRadius":"0","flexWrap":"wrap","background":"url() no-repeat center top / 100% auto","borderWidth":"16rpx 0px 16rpx 0px","width":"calc(100% - 60rpx)","position":"relative","borderStyle":"dotted dashed dotted","height":"auto"}' @tap="onPageTap('../user-info/user-info')" class="header" v-bind:class="{'status':isH5Plus}">
				<view :style='{"padding":"0","margin":"0","alignItems":"flex-start","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 200rpx)","position":"static","height":"auto"}' v-if="tableName=='yonghu'" class="userinfo">
					<image :style='{"padding":"0px","margin":"52rpx 0 20rpx","borderColor":"#1bd0a9","objectFit":"cover","textAlign":"center","right":"40rpx","borderRadius":"100%","background":"none","borderWidth":"0px 0px 0px","width":"160rpx","position":"absolute","borderStyle":"solid","height":"160rpx"}' :src="user.touxiang?baseUrl+user.touxiang:'/static/gen/upload.png'"></image>
					<view :style='{"padding":"24rpx 16rpx 60rpx","boxShadow":"inset 0px 0px 0px 0px #f9edd9","margin":"0 auto","borderColor":"#1bd0a9","flexDirection":"column","display":"flex","float":"left","justifyContent":"center","minHeight":"400rpx","borderRadius":"0px","background":"none","borderWidth":"0px 0px 0px 0px","width":"100%","borderStyle":"solid","height":"auto"}' class="info">
						<view :style='{"padding":"4rpx 8rpx","borderColor":"#0bd9ed","margin":"0 0 0px","color":"#35afc0","borderWidth":"0 0 2rpx","width":"90%","lineHeight":"72rpx","fontSize":"24rpx","borderStyle":"dashed"}'>{{user.yonghuming}}<text v-if="user.vip&& user.vip=='是'">(VIP)</text></view>
					</view>
				</view>
				<view :style='{"padding":"32rpx 0 0","margin":"240rpx 0px 0","borderColor":"#1bd0a9","alignItems":"flex-start","background":"none","borderWidth":"0px 0px 0px","display":"flex","width":"160rpx","borderStyle":"solid","justifyContent":"center","height":"auto"}' class="setting">
					<view :style='{"border":"0","width":"72rpx","lineHeight":"72rpx","fontSize":"72rpx","color":"#35afc0","borderRadius":"0"}' class="cuIcon-settings"></view>
				</view>
			</view>
		
		
			<view :style='{"padding":"20rpx 0px","boxShadow":"inset 0px 0px 0px 0px #f9edd9","margin":"0 32rpx","borderColor":"#1bd0a9","alignItems":"flex-start","display":"flex","justifyContent":"space-between","borderRadius":"0px","flexWrap":"wrap","background":"none","borderWidth":"0px 0px 0px 0px","width":"calc(100% - 0px)","borderStyle":"solid","height":"auto"}' class="list">

				<block v-for="item in menuList" v-bind:key="item.roleName">
					<block v-if="role==item.roleName" v-bind:key="index" v-for=" (menu,index) in item.backMenu">
						<block v-bind:key="sort" v-for=" (child,sort) in menu.child">
							<view :style='{"padding":"0 20rpx 0px","boxShadow":"inset 0px 0px 0px 0px #f9edd9","borderColor":"#ef8375 #f7b015 #86c790 #ffdc00","margin":"0 0 40rpx","whiteSpace":"nowrap","alignItems":"center","display":"flex","overflow":"hidden","borderRadius":"0px","borderWidth":"0px 0px 0px","background":"url(http://codegen.caihongy.cn/20221223/6b85fcf145f4443f8e0c6a1d35ff48d3.png) no-repeat left top / 100% auto,url(http://codegen.caihongy.cn/20221223/f37ce3301ae04b20b8b81e44b07f3934.png) no-repeat right bottom / 100% auto,url(http://codegen.caihongy.cn/20221223/1db3995025f1402b9bbef192396a51b4.png) repeat-y center center / 100% auto","width":"48%","lineHeight":"100rpx","textOverflow":"ellipsis","borderStyle":"solid","height":"100rpx"}' v-if="child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan' && child.tableName!='exampaper' && child.tableName!='examquestion' " @tap="onPageTap('../'+child.tableName+'/list?userid='+user.id)" class="li" hover-class="hover">
								<view v-if="true" :style='{"width":"64rpx","lineHeight":"64rpx","fontSize":"56rpx","color":"#35afc0"}' :class="child.appFrontIcon"></view>
								<view :style='{"width":"100%","padding":"0 20rpx","lineHeight":"88rpx","fontSize":"28rpx","color":"#35afc0","flex":"1"}' class="text">{{child.menu}}</view>
								<view v-if="true" :style='{"width":"28rpx","lineHeight":"28rpx","fontSize":"28rpx","color":"#35afc0"}' class="cuIcon-right"></view>
							</view>
						</block>
					</block>
				</block>

				<view @tap="onPageTap('../forum-add-or-update/forum-add-or-update')" :style='{"padding":"0 20rpx 0px","boxShadow":"inset 0px 0px 0px 0px #f9edd9","borderColor":"#ef8375 #f7b015 #86c790 #ffdc00","margin":"0 0 40rpx","whiteSpace":"nowrap","alignItems":"center","display":"flex","overflow":"hidden","borderRadius":"0px","borderWidth":"0px 0px 0px","background":"url(http://codegen.caihongy.cn/20221223/6b85fcf145f4443f8e0c6a1d35ff48d3.png) no-repeat left top / 100% auto,url(http://codegen.caihongy.cn/20221223/f37ce3301ae04b20b8b81e44b07f3934.png) no-repeat right bottom / 100% auto,url(http://codegen.caihongy.cn/20221223/1db3995025f1402b9bbef192396a51b4.png) repeat-y center center / 100% auto","width":"48%","lineHeight":"100rpx","textOverflow":"ellipsis","borderStyle":"solid","height":"100rpx"}' class="li"
				 hover-class="hover">
					<view v-if="true" :style='{"width":"64rpx","lineHeight":"64rpx","fontSize":"56rpx","color":"#35afc0"}' class="cuIcon-scan"></view>
					<view class="text" :style='{"width":"100%","padding":"0 20rpx","lineHeight":"88rpx","fontSize":"28rpx","color":"#35afc0","flex":"1"}'>我要发贴</view>
					<view v-if="true" :style='{"width":"28rpx","lineHeight":"28rpx","fontSize":"28rpx","color":"#35afc0"}' class="cuIcon-right"></view>
				</view>
				<view @tap="onPageTap('../forum-my/forum-my')" :style='{"padding":"0 20rpx 0px","boxShadow":"inset 0px 0px 0px 0px #f9edd9","borderColor":"#ef8375 #f7b015 #86c790 #ffdc00","margin":"0 0 40rpx","whiteSpace":"nowrap","alignItems":"center","display":"flex","overflow":"hidden","borderRadius":"0px","borderWidth":"0px 0px 0px","background":"url(http://codegen.caihongy.cn/20221223/6b85fcf145f4443f8e0c6a1d35ff48d3.png) no-repeat left top / 100% auto,url(http://codegen.caihongy.cn/20221223/f37ce3301ae04b20b8b81e44b07f3934.png) no-repeat right bottom / 100% auto,url(http://codegen.caihongy.cn/20221223/1db3995025f1402b9bbef192396a51b4.png) repeat-y center center / 100% auto","width":"48%","lineHeight":"100rpx","textOverflow":"ellipsis","borderStyle":"solid","height":"100rpx"}' class="li"
				 hover-class="hover">
					<view v-if="true" :style='{"width":"64rpx","lineHeight":"64rpx","fontSize":"56rpx","color":"#35afc0"}' class="cuIcon-scan"></view>
					<view class="text" :style='{"width":"100%","padding":"0 20rpx","lineHeight":"88rpx","fontSize":"28rpx","color":"#35afc0","flex":"1"}'>我的发贴</view>
					<view v-if="true" :style='{"width":"28rpx","lineHeight":"28rpx","fontSize":"28rpx","color":"#35afc0"}' class="cuIcon-right"></view>
				</view>

			</view>
		</view>
	</view>
</template>
<script>
	import menu from '@/utils/menu'
	export default {
		data() {
			return {
				isH5Plus: true,
				user: {},
				tableName:'',
				role: '',
				menuList: [],
        iconArr: [
          'cuIcon-same',
          'cuIcon-deliver',
          'cuIcon-evaluate',
          'cuIcon-shop',
          'cuIcon-ticket',
          'cuIcon-cascades',
          'cuIcon-discover',
          'cuIcon-question',
          'cuIcon-pic',
          'cuIcon-filter',
          'cuIcon-footprint',
          'cuIcon-pulldown',
          'cuIcon-pullup',
          'cuIcon-moreandroid',
          'cuIcon-refund',
          'cuIcon-qrcode',
          'cuIcon-remind',
          'cuIcon-profile',
          'cuIcon-home',
          'cuIcon-message',
          'cuIcon-link',
          'cuIcon-lock',
          'cuIcon-unlock',
          'cuIcon-vip',
          'cuIcon-weibo',
          'cuIcon-activity',
          'cuIcon-friendadd',
          'cuIcon-friendfamous',
          'cuIcon-friend',
          'cuIcon-goods',
          'cuIcon-selection'
        ],
			};
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
		async onLoad(){
			this.role = uni.getStorageSync("role");
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.user = res.data;
			this.tableName = table;
			let menus = menu.list();
			this.menuList = menus;
		},
		async onShow(){
            uni.removeStorageSync("useridTag");
			this.role = uni.getStorageSync("role");
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.user = res.data;
			this.tableName = table;
			let menus = menu.list();
			this.menuList = menus;
		},
		methods: {
			onPageTap(url) {
                uni.setStorageSync("useridTag",1);
				uni.navigateTo({
					url: url,
					fail: function() {
						uni.switchTab({
							url: url
						});
					}
				});
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		height: calc(100vh - 94px);
		box-sizing: border-box;
	}
</style>
