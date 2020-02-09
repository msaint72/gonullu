<template>
 <div id="footer">
     <separator>
         <div class="container">
             <div class="row" style="overflow: hidden;">
                 <div class="col-xs-6  col-sm-4 ">
                     <div >
                         <h3>
                             VolunteerMark
                             <br>
                         </h3>
                             <small>
                                 <router-link to="/about/">About Us</router-link> <br>
                                 <router-link to="/vmnode/volunteer/signups/ui/">Find My Shift</router-link><br>
                                 <router-link to="/affiliate-program">Affiliate Program</router-link><br>
                                 <router-link to="/sponsor/index.html">Sponsorship Program</router-link><br>
                                 <router-link to="/media/index.html">Media Room</router-link><br>
                             </small>
                     </div>
                 </div>
                 <div class="col-xs-6 col-sm-4">
                     <div>
                         <h3>
                             Use Cases
                             <br>
                             <small id="myList">
                                 <router-link to="/animal-rescue-voluteering/" >Animal Rescue and Rights Groups</router-link><br>
                                 <router-link to="/healthcare-volunteering/" >Healthcare Organizations Volunteering</router-link><br>
                                 <router-link to="/libraries/" >Library Volunteering</router-link><br>
                                 <router-link to="/nonprofit-volunteering/" >Nonprofit Volunteering</router-link><br>
                                 <router-link to="/political-campaigns/" >Political Campaign Volunteering</router-link><br>
                                 <router-link to="/school-volunteering/" >School Volunteering</router-link><br>
                             </small>
                         </h3>
                     </div>
                 </div>
                 <div class="col-xs-6  col-sm-4">
                     <div >
                         <h3>
                             Support
                             <br>
                             <small>
                                 <router-link to="/contact.html">Contact Us</router-link><br>
                                 <router-link to="/tutorials/">Learning Center</router-link><br>
                                 <router-link to="/about/security.html">Security</router-link><br>
                             </small>
                         </h3>
                     </div>
                 </div>
             </div>
         </div>
     </separator>
     </div>
</template>

<script>
    import Separator from '../Separator.vue'
export default {
  name: 'MainFooter',
    components: {Separator}
}

</script>

<style scoped>
    .container {
        font-size: 14px;
        color: #2c3e50;
    }
    h3{
        font-size: 16px;
    }
    a{
        font-size: 14px;
        color: dimgrey;
    }
</style>
