<template>
  <div>
    <div class="loading" v-if='isLoading'>
      <img src="../assets/ping_pong_loader.gif" alt="Please wait">
      </div>
    <h1>{{card.title}}</h1>
    <p>{{card.description}}</p>
    <comments-list v-bind:comments="card.comments"/>
    
  <router-link :to="{name: 'Board', params: {id: $route.params.boardID}}">
  Go back to Board {{$route.params.boardID}}
    </router-link>
  </div>
</template>

<script>
import boardService from '../services/BoardService';
import CommentsList from './CommentsList.vue';
export default {
  name: "card-detail",
  data(){
    return{
      card:{
        title: '',
        description:'',
        status:'',
        comments:[]
      },
      isLoading: true
    }
  },
  created(){
    boardService
    .getCard(this.$route.params.boardID,this.$route.params.cardID)
    .then(
      response => {

       this.card = response;
       this.islaoding = false;
      }
    );
  }
};
</script>
