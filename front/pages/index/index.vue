<template>
<view class="content">
	<view :style='{"minHeight":"100vh","width":"100%","padding":"24rpx 0 0px","background":"#192231","height":"auto"}'>
		<swiper :style='{"padding":"0px 0 12rpx ","boxShadow":"inset 0px 0px 0px 0px #f4ead8","borderColor":"#0bd9ed","outline":"0px solid #bbb","margin":"0px auto 40rpx","borderRadius":"20%","background":"rgba(11,217,237,.1)","borderWidth":"16rpx 8rpx 4rpx 8rpx","width":"calc(100% - 40rpx)","borderStyle":"groove","height":"412rpx"}' class="swiper" :indicator-dots='false' :autoplay='true' :circular='false' indicator-active-color='#000000' indicator-color='rgba(0, 0, 0, .3)' :duration='500' :interval='5000' :vertical='false'>
			<swiper-item :style='{"width":"calc(100% - 0px)","margin":"0 auto","position":"relative","borderRadius":"20%","background":"none","height":"400rpx"}' v-for="(swiper,index) in swiperList" :key="index" @tap="onSwiperTap(swiper)">
				<image :style='{"width":"calc(100% - 40rpx)","margin":"16rpx auto","objectFit":"cover","borderRadius":"20%","display":"block","height":"360rpx"}' mode="aspectFill" :src="baseUrl+swiper.img"></image>
				<view v-if="false" :style='{"padding":"0 20rpx 32rpx","color":"#333","left":"20rpx","textAlign":"center","background":"rgba(255,255,255,.6)","bottom":"0px","width":"calc(100% - 40rpx)","lineHeight":"60rpx","fontSize":"28rpx","position":"absolute"}'>{{ swiper.title }}</view>
			</swiper-item>
		</swiper>

		<view class="cu-bar bg-white search" :style="[{top:CustomBar + 'px'}]">
			<picker v-if="queryList.length>1" mode="selector" :range="queryList" range-key="queryName" :value="queryIndex" @change="queryChange" style="padding-left: 20upx;">
				<view><image style="width: 20upx;height: 33upx;" src="../../static/center/to.png"></image></view>
			</picker>
			<view v-if="queryIndex==0" class="search-form round">
				<text class="cuIcon-search"></text>
				<input v-model="searchForm.wenzhangxinxiwenzhangbiaoti" type="text" placeholder="文章标题" ></input>
			</view>
			<view v-if="queryIndex==0" class="action">
				<button @tap="onPageTap('wenzhangxinxi')" class="cu-btn shadow-blur round">搜索</button>
			</view>
		</view>

		<!-- menu -->
		<view v-if="true" class="menu" :style='{"padding":"20rpx 0 20rpx","boxShadow":"inset 0px 0px 0px 0px #87acf1","margin":"40rpx auto 40rpx","borderColor":"#0bd9ed","display":"flex","outline":"0px solid #ccc","borderRadius":"20%","flexWrap":"wrap","background":"rgba(11,217,237,.1)","borderWidth":"4rpx 8rpx 16rpx 8rpx","width":"calc(100% - 40rpx)","borderStyle":"groove","height":"auto"}'>
            <block v-for="item in menuList" v-bind:key="item.roleName">
                <block v-if="role==item.roleName" v-bind:key="index" v-for=" (menu,index) in item.frontMenu">
                    <block v-bind:key="sort" v-for=" (child,sort) in menu.child">
                        <block v-bind:key="sort2" v-for=" (button,sort2) in child.buttons">
                            <view :style='{"width":"25%","padding":"12rpx 0","margin":"10rpx 0","height":"auto"}' class="menu-list" v-if="button=='查看' && child.tableName!='yifahuodingdan' && child.tableName!='yituikuandingdan' &&child.tableName!='yiquxiaodingdan' && child.tableName!='weizhifudingdan' && child.tableName!='yizhifudingdan' && child.tableName!='yiwanchengdingdan' " @tap="onPageTap2('../'+child.tableName+'/list')">
                                <view class="iconarr" :class="child.appFrontIcon" :style='{"padding":"0","margin":"0px auto","color":"#35afc0","borderRadius":"100%","background":"none","display":"block","width":"64rpx","lineHeight":"64rpx","fontSize":"64rpx","height":"64rpx"}'></view>
                                <view :style='{"padding":"0","margin":"12rpx auto 0","color":"#35afc0","textAlign":"center","width":"100%","lineHeight":"28rpx","fontSize":"28rpx"}'>{{child.menu.split("列表")[0]}}</view>
                            </view>
                        </block>
                    </block>
                </block>
            </block>
		</view>
		<!-- menu -->
		
		
		<!-- 系统简介 -->
		<view :style='{"padding":"0px","boxShadow":"0 0px 0px rgba(0,0,0,.2)","margin":"80rpx auto 40rpx","borderRadius":"0px","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20221224/7e3cf68e360446639633a87989cda19c.gif) no-repeat center top / 100% auto","display":"flex","width":"calc(100% - 48rpx)","position":"relative","justifyContent":"center","height":"auto"}'>
		  <view :style='{"minHeight":"120rpx","padding":"40rpx 40rpx 0","margin":"0","overflow":"hidden","color":"#35afc0","borderRadius":"0px","textAlign":"center","background":"url(http://codegen.caihongy.cn/20221224/a7a84be25ba14876b37b435e06e66737.png) no-repeat center top / 100% auto,url(http://codegen.caihongy.cn/20221224/9795faa3c16747b7ae6a02b3ee80bae3.png) no-repeat center bottom / 100% auto,url(http://codegen.caihongy.cn/20221224/0982a2f10bee4481a22d37de1faea15d.png) repeat-y center center / 100% auto","width":"100%","lineHeight":"120rpx","fontSize":"32rpx","fontWeight":"600"}'>{{systemIntroductionDetail.title}}</view>
		  <view :style='{"padding":"0px 80rpx 0 16rpx","margin":"0","overflow":"hidden","color":"#fff","borderRadius":"0","textAlign":"center","background":"url() no-repeat right top / auto 100%,#5489ed","display":"none","width":"auto","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'>{{systemIntroductionDetail.subtitle}}</view>
		  <view :style='{"padding":"0px","margin":"60rpx 0 0px 0","borderColor":"#0bd9ed","borderRadius":"100rpx","background":"url() no-repeat right top","borderWidth":"16rpx 16rpx 4rpx","display":"flex","width":"100%","position":"relative","borderStyle":"ridge","justifyContent":"space-between","height":"auto"}'>
		    <img :style='{"padding":"0px","boxShadow":"inset 0px 0px 0px 0px #edf3fe","margin":"0","borderColor":"#60dfc4","objectFit":"cover","borderRadius":"80rpx","borderWidth":"0px","display":"block","width":"100%","borderStyle":"solid","height":"320rpx"}' v-if="systemIntroductionDetail.picture1" :src="baseUrl+systemIntroductionDetail.picture1">
		    <img :style='{"padding":"20rpx","boxShadow":"inset 0px 0px 0px 0px #edf3fe","margin":"0","borderColor":"#60dfc4","objectFit":"cover","borderRadius":"0 0px 0px 0","borderWidth":"0px","display":"none","width":"48%","borderStyle":"solid","height":"240rpx"}' v-if="systemIntroductionDetail.picture2" :src="baseUrl+systemIntroductionDetail.picture2">
		    <img :style='{"padding":"24rpx","boxShadow":"inset 0px 0px 112rpx 0px #fff","margin":"0","borderColor":"#e9be70","objectFit":"cover","display":"none","right":"12rpx","borderRadius":"10%","borderWidth":"8rpx 4rpx 4rpx 4rpx","width":"30%","position":"absolute","borderStyle":"solid","height":"400rpx"}' v-if="systemIntroductionDetail.picture3" :src="baseUrl+systemIntroductionDetail.picture3">
		  </view>
		  <view :style='{"padding":"20rpx 20rpx 40rpx","boxShadow":"inset 0px 0px 0px 0px #87acf1","margin":"0px 0 0px 0","borderColor":"#0bd9ed","color":"#35afc0","textIndent":"2em","borderRadius":"100rpx","background":"url() no-repeat right top,rgba(105,213,223,.1)","borderWidth":"4rpx 16rpx 16rpx","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","borderStyle":"ridge","height":"auto"}' v-html="systemIntroductionDetail.content"></view>
		  <view :style='{"width":"82%","position":"absolute","top":"208rpx","background":"url() no-repeat","display":"block","height":"36rpx"}' />
		  <view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
		</view>

		<!-- 商品推荐 -->
		<view class="listBox recommend">
			<view v-if="false && 1 == 1" class="idea recommendIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
			<view class="title" :style='{"padding":"40rpx 0 0px","boxShadow":"0px 0px 0px rgba(0,0,0,.1)","margin":"80rpx auto 40rpx","borderColor":"#eee","textAlign":"center","minHeight":"120rpx","overflow":"hidden","borderRadius":"0","background":"url(http://codegen.caihongy.cn/20221224/a7a84be25ba14876b37b435e06e66737.png) no-repeat center top / 100% auto,url(http://codegen.caihongy.cn/20221224/9795faa3c16747b7ae6a02b3ee80bae3.png) no-repeat center bottom / 100% auto,url(http://codegen.caihongy.cn/20221224/0982a2f10bee4481a22d37de1faea15d.png) repeat-y center center / 100% auto","borderWidth":"0px","width":"calc(100% - 40rpx)","lineHeight":"120rpx","borderStyle":"groove","height":"auto"}'>
				<view :style='{"padding":"0 100rpx","boxShadow":"0px 0px 0px rgba(0,0,0,.2)","margin":"0","color":"#35afc0","borderRadius":"0","textAlign":"center","background":"none","display":"inline-block","width":"auto","fontSize":"32rpx","fontWeight":"600"}'>文章信息推荐</view>
			</view>
			
			<view v-if="false && 1 == 2" class="idea recommendIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
			
			
			<!-- 样式3 -->
			<view class="list-box style3" :style='{"width":"100%","padding":"0px 40rpx","margin":"0","background":"none","height":"auto"}'>
				<view @tap="onDetailTap('wenzhangxinxi',product.id)" v-for="(product,index) in wenzhangxinxilist" :key="index" class="list-item" :style='{"border":"0px solid #0bd9ed","padding":"24rpx 24rpx","margin":"0 0 32rpx","borderColor":"#67bfc7","borderRadius":"24rpx","flexWrap":"wrap","borderWidth":"2rpx 2rpx 4rpx","background":"rgba(105,213,223,.1)","display":"flex","width":"100%","borderStyle":"dotted dashed solid dashed","height":"auto"}'>
					<image :style='{"width":"200rpx","objectFit":"cover","display":"block","height":"200rpx"}' class="list-item-image" mode="aspectFill" v-if="product.fengmian.substring(0,4)=='http'" :src="product.fengmian"></image>
					<image :style='{"width":"200rpx","objectFit":"cover","display":"block","height":"200rpx"}' class="list-item-image" mode="aspectFill" v-else :src="product.fengmian?baseUrl+product.fengmian.split(',')[0]:''"></image>
					<view class="list-item-body" :style='{"width":"calc(100% - 200rpx)","padding":"0","margin":"0","height":"auto"}'>
						<view :style='{"padding":"0 20rpx","margin":"0","whiteSpace":"nowrap","overflow":"hidden","color":"#35afc0","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis"}' class="list-item-title">{{product.wenzhangbiaoti}}</view>
						<view :style='{"padding":"0 20rpx","margin":"0","whiteSpace":"nowrap","overflow":"hidden","color":"#35afc0","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis"}' class="list-item-title">标签:{{product.biaoqian}}</view>
					</view>
				</view>
			</view>
			
			  
			
			
			  
			
			  
			<view v-if="false && 1 == 3" class="idea recommendIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
		</view>
		<!-- 商品推荐 -->
		

		<!-- 新闻资讯 -->
																														<view class="listBox news">
			<view v-if="false && 1 == 1" class="idea newsIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
			<view class="title" :style='{"minHeight":"120rpx","padding":"40rpx 0 0","boxShadow":"0px 0px 0px rgba(0,0,0,.1)","margin":"0 auto 0px","overflow":"hidden","borderRadius":"0","background":"url(http://codegen.caihongy.cn/20221224/a7a84be25ba14876b37b435e06e66737.png) no-repeat center top / 100% auto,url(http://codegen.caihongy.cn/20221224/9795faa3c16747b7ae6a02b3ee80bae3.png) no-repeat center bottom / 100% auto,url(http://codegen.caihongy.cn/20221224/0982a2f10bee4481a22d37de1faea15d.png) repeat-y center center / 100% auto","display":"flex","width":"calc(100% - 40rpx)","lineHeight":"120rpx","position":"relative","justifyContent":"space-between"}'>
				<view :style='{"padding":"0 0 0 160rpx","boxShadow":"0px 0px 0px rgba(0,0,0,.2)","margin":"0px 0 0","color":"#35afc0","borderRadius":"0px","textAlign":"center","background":"none","display":"inline-block","width":"calc(100% - 160rpx)","fontSize":"32rpx","fontWeight":"600"}'>公告资讯</view>
				<text :style='{"padding":"0 40rpx 0 0","margin":"0px 0px 0 0","color":"#4c7d96","textAlign":"right","background":"none","fontSize":"28rpx","minWidth":"160rpx","position":"absolute","right":"0"}' @tap="onPageTap('news')">查看更多</text>
			</view>
			
			<view v-if="false && 1 == 2" class="idea newsIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
					  
						
						
		  <!-- 样式4 -->
		  		  
		  <!-- 样式5 -->
		  		  
		  <!-- 样式6 -->
		  		  
		  <!-- 样式7 -->
		  		  
		  <!-- 样式8 -->
		  		  
		  <!-- 样式9 -->
		  		  <view class="news-box6" :style='{"width":"100%","padding":"24rpx 40rpx","margin":"24rpx 0 0","background":"url(http://codegen.caihongy.cn/20221224/7e3cf68e360446639633a87989cda19c.gif) no-repeat center bottom / 100% auto","height":"auto"}'>
			<view @tap="onNewsDetailTap(item.id)" v-for="(item,index) in news" :key="index" class="list-item" :style='{"padding":"8rpx 24rpx 8rpx 100rpx","margin":"0 0 20rpx","borderColor":"#67bfc7","background":"rgba(105,213,223,.1)","borderWidth":"2rpx 2rpx 4rpx","width":"100%","position":"relative","borderStyle":"dotted dashed solid double","height":"auto"}'>
			  <view :style='{"padding":"0","margin":"-28rpx 0 0 20rpx","borderColor":"#67bfc7","color":"#67bfc7","textAlign":"center","borderRadius":"100%","top":"50%","left":"0","borderWidth":"2rpx","width":"60rpx","lineHeight":"60rpx","fontSize":"28rpx","position":"absolute","borderStyle":"solid","height":"60rpx"}' class="num">
			    <view style="width: 100%;height: 100%;position: absolute;left: 0;top: 0;" :style="{transform: 'rotate('+(-index*60)+'deg)'}" class="dian">
			      <view :style='{"transform":"translateX(-50%)","borderRadius":"100%","top":"-8rpx","left":"50%","background":"#0bd9ed","display":"none","width":"16rpx","position":"absolute","height":"16rpx"}'></view>
			    </view>{{ index + 1 < 10 ? '0'+(index+1) : index+1 }}
			  </view>
			  <view class="item-list-body" :style='{"width":"100%","margin":"0","height":"auto"}'>
				<view :style='{"padding":"8rpx 20rpx","whiteSpace":"nowrap","overflow":"hidden","color":"#35afc0","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis"}' class="title ">{{item.title}}</view>
				<view :style='{"padding":"4rpx 20rpx","overflow":"hidden","color":"#4a8189","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textIndent":"2em","height":"96rpx"}' class="desc ">{{item.introduction}}</view>
			  </view>
			</view>
		  </view>
		  			
			<view v-if="false && 1 == 3" class="idea newsIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
		</view>
														<!-- 新闻资讯 -->
				

		<!-- 商品列表 -->
														<view class="listBox list">
			<view v-if="false && 1 == 1" class="idea listIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
		  
			<view class="title" :style='{"minHeight":"120rpx","padding":"40rpx 0 0","boxShadow":"0px 0px 0px rgba(0,0,0,.1)","margin":"0 auto 0px","overflow":"hidden","borderRadius":"0","background":"url(http://codegen.caihongy.cn/20221224/a7a84be25ba14876b37b435e06e66737.png) no-repeat center top / 100% auto,url(http://codegen.caihongy.cn/20221224/9795faa3c16747b7ae6a02b3ee80bae3.png) no-repeat center bottom / 100% auto,url(http://codegen.caihongy.cn/20221224/0982a2f10bee4481a22d37de1faea15d.png) repeat-y center center / 100% auto","display":"flex","width":"calc(100% - 40rpx)","lineHeight":"120rpx","position":"relative","justifyContent":"space-between"}'>
				<view :style='{"padding":"0 0 0 160rpx","boxShadow":"0px 0px 0px rgba(0,0,0,.2)","margin":"0px 0 0","color":"#35afc0","borderRadius":"0px","textAlign":"center","background":"url() no-repeat right top / auto 100%","display":"inline-block","width":"calc(100% - 160rpx)","fontSize":"32rpx","minWidth":"240rpx","fontWeight":"600"}'>文章信息</view>
				<text :style='{"padding":"0 40rpx","margin":"0px 0px 0 0","color":"#4c7d96","textAlign":"right","background":"none","fontSize":"28rpx","minWidth":"160rpx","position":"absolute","right":"0"}' @tap="onPageTap('wenzhangxinxi')">查看更多</text>
			</view>
			
			<view v-if="false && 1 == 2" class="idea listIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
			
		  		  
		  		  
		  		  
		  		  
		  		  
		  		  
		  		  
		  		  <!-- 样式8 -->
		  <view class="list-box style8" :style='{"width":"100%","padding":"24rpx 40rpx","margin":"40rpx 0 0","background":"none","height":"auto"}'>
			<view v-if="homewenzhangxinxilist.length > 0" @tap="onDetailTap('wenzhangxinxi',homewenzhangxinxilist[0].id)" class="box box1" :style='{"padding":"20rpx","boxShadow":"inset 0px 0px 0px 0px #fff","margin":"0 0 20rpx","borderColor":"#67bfc7","borderRadius":"0px","borderWidth":"4rpx","background":"rgba(105,213,223,.1)","width":"100%","position":"relative","borderStyle":"dotted dashed dotted dashed","height":"auto"}'>
			  			                			  <view v-if="true" :style='{"padding":"0 20rpx","margin":"8rpx 0 8rpx","color":"#35afc0","borderRadius":"20%","textAlign":"center","background":"none","width":"100%","lineHeight":"64rpx","fontSize":"28rpx","zIndex":"1"}' class="title ">{{homewenzhangxinxilist[0].wenzhangbiaoti}}</view>
			  			  			                			  			  			  <image :style='{"width":"100%","objectFit":"cover","borderRadius":"24rpx","display":"block","height":"300rpx"}' class="list-item-image" mode="aspectFill" v-if="homewenzhangxinxilist[0].fengmian.substring(0,4)=='http'" :src="homewenzhangxinxilist[0].fengmian"></image>
			  <image :style='{"width":"100%","objectFit":"cover","borderRadius":"24rpx","display":"block","height":"300rpx"}' class="list-item-image" mode="aspectFill" v-else :src="homewenzhangxinxilist[0].fengmian?baseUrl+homewenzhangxinxilist[0].fengmian.split(',')[0]:''"></image>
			                			  			                			  <view v-if="true" :style='{"padding":"0 20rpx","margin":"8rpx 0 8rpx","color":"#35afc0","borderRadius":"20%","textAlign":"center","background":"none","width":"100%","lineHeight":"64rpx","fontSize":"28rpx","zIndex":"1"}' class="title ">标签:{{homewenzhangxinxilist[0].biaoqian}}</view>
			  			  			                			  			                			  			                			  			                			  			                			  			                			  			                			  			                			  			</view>
			<view class="list-item" :style='{"width":"100%","padding":"0","margin":"0 0 20rpx","justifyContent":"space-between","display":"flex","height":"auto"}'>
			  <view v-if="homewenzhangxinxilist.length > 1" @tap="onDetailTap('wenzhangxinxi',homewenzhangxinxilist[1].id)" class="box box2" :style='{"padding":"8rpx","boxShadow":"inset 0px 0px 0px 0px #fff","margin":"0","borderColor":"#67bfc7","borderRadius":"0px","borderWidth":"2rpx 2rpx 2rpx","background":"rgba(105,213,223,.1)","width":"32%","position":"relative","borderStyle":"dotted dashed dotted dashed","height":"auto"}'>
								                				<view v-if="true" :style='{"padding":"0 20rpx","margin":"8rpx 0 8rpx","color":"#35afc0","borderRadius":"20%","textAlign":"center","background":"none","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","zIndex":"1"}' class="title ">{{homewenzhangxinxilist[1].wenzhangbiaoti}}</view>
												                												<image :style='{"width":"100%","objectFit":"cover","borderRadius":"24rpx","display":"block","height":"240rpx"}' class="list-item-image" mode="aspectFill" v-if="homewenzhangxinxilist[1].fengmian.substring(0,4)=='http'" :src="homewenzhangxinxilist[1].fengmian"></image>
				<image :style='{"width":"100%","objectFit":"cover","borderRadius":"24rpx","display":"block","height":"240rpx"}' class="list-item-image" mode="aspectFill" v-else :src="homewenzhangxinxilist[1].fengmian?baseUrl+homewenzhangxinxilist[1].fengmian.split(',')[0]:''"></image>
				                								                				<view v-if="true" :style='{"padding":"0 20rpx","margin":"8rpx 0 8rpx","color":"#35afc0","borderRadius":"20%","textAlign":"center","background":"none","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","zIndex":"1"}' class="title ">标签:{{homewenzhangxinxilist[1].biaoqian}}</view>
												                								                								                								                								                								                								                								                							  </view>
			  <view v-if="homewenzhangxinxilist.length > 2" @tap="onDetailTap('wenzhangxinxi',homewenzhangxinxilist[2].id)" class="box box3" :style='{"padding":"8rpx","boxShadow":"inset 0px 0px 0px 0px #fff","margin":"0","borderColor":"#67bfc7","borderRadius":"0px","borderWidth":"2rpx 2rpx 2rpx","background":"rgba(105,213,223,.1)","width":"32%","position":"relative","borderStyle":"dotted dashed dotted dashed","height":"auto"}'>
								                				<view v-if="true" :style='{"padding":"0 20rpx","margin":"8rpx 0 8rpx","color":"#35afc0","borderRadius":"20%","textAlign":"center","background":"none","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","zIndex":"1"}' class="title ">{{homewenzhangxinxilist[2].wenzhangbiaoti}}</view>
												                												<image :style='{"width":"100%","objectFit":"cover","borderRadius":"24rpx","display":"block","height":"240rpx"}' class="list-item-image" mode="aspectFill" v-if="homewenzhangxinxilist[2].fengmian.substring(0,4)=='http'" :src="homewenzhangxinxilist[2].fengmian"></image>
				<image :style='{"width":"100%","objectFit":"cover","borderRadius":"24rpx","display":"block","height":"240rpx"}' class="list-item-image" mode="aspectFill" v-else :src="homewenzhangxinxilist[2].fengmian?baseUrl+homewenzhangxinxilist[2].fengmian.split(',')[0]:''"></image>
				                								                				<view v-if="true" :style='{"padding":"0 20rpx","margin":"8rpx 0 8rpx","color":"#35afc0","borderRadius":"20%","textAlign":"center","background":"none","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","zIndex":"1"}' class="title ">标签:{{homewenzhangxinxilist[2].biaoqian}}</view>
												                								                								                								                								                								                								                								                							  </view>
			  <view v-if="homewenzhangxinxilist.length > 3" @tap="onDetailTap('wenzhangxinxi',homewenzhangxinxilist[3].id)" class="box box4" :style='{"padding":"8rpx","boxShadow":"inset 0px 0px 0px 0px #fff","margin":"0","borderColor":"#67bfc7","borderRadius":"0px","borderWidth":"2rpx 2rpx 2rpx","background":"rgba(105,213,223,.1)","width":"32%","position":"relative","borderStyle":"dotted dashed dotted dashed","height":"auto"}'>
								                				<view v-if="true" :style='{"padding":"0 20rpx","margin":"8rpx 0 8rpx","color":"#35afc0","borderRadius":"20%","textAlign":"center","background":"none","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","zIndex":"1"}' class="title ">{{homewenzhangxinxilist[3].wenzhangbiaoti}}</view>
												                												<image :style='{"width":"100%","objectFit":"cover","borderRadius":"24rpx","display":"block","height":"240rpx"}' class="list-item-image" mode="aspectFill" v-if="homewenzhangxinxilist[3].fengmian.substring(0,4)=='http'" :src="homewenzhangxinxilist[3].fengmian"></image>
				<image :style='{"width":"100%","objectFit":"cover","borderRadius":"24rpx","display":"block","height":"240rpx"}' class="list-item-image" mode="aspectFill" v-else :src="homewenzhangxinxilist[3].fengmian?baseUrl+homewenzhangxinxilist[3].fengmian.split(',')[0]:''"></image>
				                								                				<view v-if="true" :style='{"padding":"0 20rpx","margin":"8rpx 0 8rpx","color":"#35afc0","borderRadius":"20%","textAlign":"center","background":"none","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","zIndex":"1"}' class="title ">标签:{{homewenzhangxinxilist[3].biaoqian}}</view>
												                								                								                								                								                								                								                								                							  </view>
			</view>
			<view class="list-item" :style='{"width":"100%","padding":"0","margin":"0","justifyContent":"space-between","display":"none","height":"auto"}'>
			  <view v-if="homewenzhangxinxilist.length > 4" @tap="onDetailTap('wenzhangxinxi',homewenzhangxinxilist[4].id)" class="box box5" :style='{"padding":"16rpx","boxShadow":"inset 0px 0px 0px 0px #fff","margin":"0","borderColor":"#67bfc7","borderRadius":"24rpx","borderWidth":"2rpx 2rpx 2rpx","background":"rgba(255,255,255,.1)","width":"48%","position":"relative","borderStyle":"dotted dashed solid double","height":"auto"}'>
								                				<view v-if="true" :style='{"padding":"0 20rpx","margin":"8rpx 0 8rpx","color":"#333","borderRadius":"20%","textAlign":"center","background":"none","width":"100%","lineHeight":"56rpx","fontSize":"28rpx","zIndex":"1"}' class="title ">{{homewenzhangxinxilist[4].wenzhangbiaoti}}</view>
												                												<image :style='{"width":"100%","objectFit":"cover","borderRadius":"10%","display":"block","height":"328rpx"}' class="list-item-image" mode="aspectFill" v-if="homewenzhangxinxilist[4].fengmian.substring(0,4)=='http'" :src="homewenzhangxinxilist[4].fengmian"></image>
				<image :style='{"width":"100%","objectFit":"cover","borderRadius":"10%","display":"block","height":"328rpx"}' class="list-item-image" mode="aspectFill" v-else :src="homewenzhangxinxilist[4].fengmian?baseUrl+homewenzhangxinxilist[4].fengmian.split(',')[0]:''"></image>
				                								                				<view v-if="true" :style='{"padding":"0 20rpx","margin":"8rpx 0 8rpx","color":"#333","borderRadius":"20%","textAlign":"center","background":"none","width":"100%","lineHeight":"56rpx","fontSize":"28rpx","zIndex":"1"}' class="title ">标签:{{homewenzhangxinxilist[4].biaoqian}}</view>
												                								                								                								                								                								                								                								                							  </view>
			  <view v-if="homewenzhangxinxilist.length > 5" @tap="onDetailTap('wenzhangxinxi',homewenzhangxinxilist[5].id)" class="box box6" :style='{"padding":"16rpx","boxShadow":"inset 0px 0px 0px 0px #fff","margin":"0","borderColor":"#67bfc7","borderRadius":"24rpx","borderWidth":"2rpx 2rpx 2rpx","background":"rgba(255,255,255,.1)","width":"48%","position":"relative","borderStyle":"dotted dashed solid double","height":"auto"}'>
								                				<view v-if="true" :style='{"padding":"0 20rpx","margin":"8rpx 0 8rpx","color":"#333","borderRadius":"20%","textAlign":"center","background":"none","width":"100%","lineHeight":"56rpx","fontSize":"28rpx","zIndex":"1"}' class="title ">{{homewenzhangxinxilist[5].wenzhangbiaoti}}</view>
												                												<image :style='{"width":"100%","objectFit":"cover","borderRadius":"10%","display":"block","height":"328rpx"}' class="list-item-image" mode="aspectFill" v-if="homewenzhangxinxilist[5].fengmian.substring(0,4)=='http'" :src="homewenzhangxinxilist[5].fengmian"></image>
				<image :style='{"width":"100%","objectFit":"cover","borderRadius":"10%","display":"block","height":"328rpx"}' class="list-item-image" mode="aspectFill" v-else :src="homewenzhangxinxilist[5].fengmian?baseUrl+homewenzhangxinxilist[5].fengmian.split(',')[0]:''"></image>
				                								                				<view v-if="true" :style='{"padding":"0 20rpx","margin":"8rpx 0 8rpx","color":"#333","borderRadius":"20%","textAlign":"center","background":"none","width":"100%","lineHeight":"56rpx","fontSize":"28rpx","zIndex":"1"}' class="title ">标签:{{homewenzhangxinxilist[5].biaoqian}}</view>
												                								                								                								                								                								                								                								                							  </view>
			</view>
		  </view>
		  		  
		  		  
			<view v-if="false && 1 == 3" class="idea listIdea" :style='{"padding":"40rpx","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box1"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box2"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box3"></view>
				<view :style='{"width":"20%","background":"#fff","height":"160rpx"}' class="box box4"></view>
			</view>
		</view>
																														<!-- 商品列表 -->
		
		

	</view>
</view>
</template>

<script>
    import menu from '@/utils/menu'
	import '@/assets/css/global-restaurant.css'
	import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
	export default {
		components: {
			uniIcons
		},
		data() {
			return {
				options2: {
					effect: 'flip',
					loop : true
				},
				options3: {
					effect: 'cube',
					loop : true,
					cubeEffect: {
						shadow: true,
						slideShadows: true,
						shadowOffset: 20,
						shadowScale: 0.94,
					}
				},
				rows: 2,
				column: 4,
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
                role : '',
                systemIntroductionDetail: {},
                menuList: [],
                swiperMenuList:[],
                user: {},
                tableName:'',
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				queryList:[
					{
						queryName:"文章标题",
					},
				],
				queryIndex: 0,
				searchForm:{
					wenzhangxinxiwenzhangbiaoti:'',
				},
				CustomBar: '0',

				//轮播
				swiperList: [],
				wenzhangxinxilist: [],
				homewenzhangxinxilist: [],
				news: [],
			}
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
            this.menuList.forEach((item,key) => {
                if(this.role==item.roleName) {
                    item.frontMenu.forEach((item2,key2) => {
                        if(item2.child[0].buttons.indexOf("查看")>-1) {
                            this.swiperMenuList.push(item2);
                        }
                    })
                }
            })
        },
		async onShow() {
            this.btnColor = this.btnColor.sort(()=> {
                    return (0.5-Math.random());
            });
			// 轮播图
			let swiperList = []
			let res = await this.$api.page('config', {
				page: 1,
				limit: 5
			});
			for (let item of res.data.list) {
				if (item.name.indexOf('picture') >= 0 && item.value && item.value!="" && item.value!=null ) {
					swiperList.push({
						img: item.value,
                        title: item.name
					});
				}
			}
			if (swiperList) {
				this.swiperList = swiperList;
			}
            this.getSystemIntroduction();
			// 公告资讯
			res = await this.$api.list('news', {
				page: 1,
				limit: 6
			});
			this.news = res.data.list

			// 推荐信息
			res = await this.$api.recommend('wenzhangxinxi', {                                              
                page: 1,
                limit: 4
            });
			this.wenzhangxinxilist = res.data.list

			res = await this.$api.list('wenzhangxinxi', {
				page: 1,
        sort: 'fabushijian',
        order: 'desc',

				limit: 6
			});
			this.homewenzhangxinxilist = res.data.list
		},

		methods: {

			//查询条件切换
			queryChange(e) {
				this.queryIndex=e.detail.value;
				this.searchForm.wenzhangxinxiwenzhangbiaoti="";
			},
			//轮播图跳转
			onSwiperTap(e) {

			},
            async getSystemIntroduction() {
                let res = await this.$api.info('systemintro', 1)
                this.systemIntroductionDetail = res.data;
            },
			// 新闻详情
			onNewsDetailTap(id) {
				this.$utils.jump(`../news-detail/news-detail?id=${id}`)
			},
			// 推荐列表点击详情
			onDetailTap(tableName, id) {
				this.$utils.jump(`../${tableName}/detail?id=${id}`)
			},
			onPageTap(tableName){
				if(this.queryIndex==0) {
					uni.setStorageSync('indexQueryCondition',this.searchForm.wenzhangxinxiwenzhangbiaoti);
					this.searchForm.wenzhangxinxiwenzhangbiaoti = '';
				}

				uni.navigateTo({
					url: `../${tableName}/list`,
					fail: function(){
						uni.switchTab({
							url: `../${tableName}/list`
						});
					}
				});
				// this.$utils.jump(`../${tableName}/list`)
			},
            onPageTap2(url) {
                uni.setStorageSync("useridTag",0);
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
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
