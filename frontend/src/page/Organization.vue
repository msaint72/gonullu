<template>
    <b-container fluid class="bv-example-row pt-1">
        <b-row align-h="center">
            <b-col sm="6" md="4" lg="3" class="justify-content-md-center" align="center">
                <div >
                    <b-img thumbnail fluid src="https://i.picsum.photos/id/326/250/250.jpg" alt="Image 1"></b-img>
                    <b-button size="sm" class="mt-2 p-2 h-10" sm variant="outline-info">upload image</b-button>
                </div>
            </b-col>
            <b-col sm="6" md="8" lg="7">
                <b-form>
                    <b-form-group
                            description="Organization Name">
                        <b-form-input
                                id="name"
                                v-model="form.name"
                                type="text"
                                required
                                placeholder="Enter organization name"
                        ></b-form-input>
                    </b-form-group>
                    <b-form-group description="Organization causes">
                        <multiselect
                                v-model="form.causes"
                                :options="causeList"
                                :multiple="true"
                                :close-on-select="false"
                                :clear-on-select="false"
                                :preserve-search="true"
                                placeholder="Choose organization causes" label="name" track-by="name" :preselect-first="false">
                            <template slot="selection" slot-scope="{ values, search, isOpen }"></template>
                        </multiselect>
                    </b-form-group>
                        <b-form-group
                            description="Organization description">
                        <b-form-textarea
                                rows="3"
                                max-rows="6"
                                v-model="form.summary"
                                placeholder="Enter organization description"
                        ></b-form-textarea>
                    </b-form-group>
                    <b-form-group  description="Phone">
                        <b-form-input
                                id="tel"
                                v-model="form.phone"
                                type="tel"
                                required
                                placeholder="Enter phone number"
                        ></b-form-input>
                    </b-form-group>
                    <b-form-group  description="Web address">
                        <b-form-input
                                id="url"
                                v-model="form.web"
                                type="url"
                                required
                                placeholder="Enter web site address"
                        ></b-form-input>
                    </b-form-group>
                    <b-button type="submit" @click.prevent="submit">Save</b-button>
                </b-form>
            </b-col>
        </b-row>
    </b-container>
</template>
<style src="vue-multiselect/dist/vue-multiselect.min.css"></style>
<script>

    import {mapGetters,mapActions} from 'vuex';
    import Multiselect from 'vue-multiselect';
    export default {
        components: {
            Multiselect
        },        data() {
            return {
                form: {
                    name: '',
                    causes: [],
                    summary:'',
                    address: '',
                    province:'',
                    district:'',
                    zipcode:'',
                    phone:'',
                    web:'',
                    checked: []
                },
                value: [],
                show: true,
                provinces: [{ text: 'Select Province', value: null }, 'Ankara', 'İstanbul', 'İzmir', 'Konya'],
                districts: [{ text: 'Select District', value: null }, 'Çankaya', 'Keçiören', 'Yenimahalle'],
                causeOptionList: [{name:'Hayvan Hakları'},{name:'Din'},{name:'Sağlık'},{name:'Çevre'},{name:'Kültür Sanat'}]
            }
        },
        computed :{
            ...mapGetters(['user','causeList']),
            ...mapGetters('organizationStore', ['organization']),
        },
        created(){
            console.log("getting org with id:"+this.user.orgId);
            this.getOrganization();
        },
        mounted: function(){
        },
        methods: {
        ...mapActions('organizationStore', ['getOrgData','saveOrganization','getCauseList']),
            getOrganization(){
                console.log("getting org data...");
                this.getOrgData({ id:this.user.orgId,
                    token:this.$store.getters.token} )
                    .then(()=>{
                        this.form.name=this.organization.name
                        this.form.summary=this.organization.summary,
                        this.form.phone=this.organization.phone,
                        this.form.web=this.organization.web;
                        console.log("len:"+this.form.causes.length);
                        if(this.form.causes.length==0){
                            this.organization.causes.forEach((cause)=>{
                                console.log(cause.name);
                                this.form.causes.push({name: cause.name});
                            });
                        }
                    });
            },
            submit(){
                console.log(this.form);
                console.log(this.$store.getters.token);
                this.saveOrganization(
                        { organization: {
                                id : this.organization.id,
                                name : this.form.name,
                                summary: this.form.summary,
                                phone: this.form.phone,
                                web:this.form.web,
                                causes:[...this.form.causes]
                            }, token:this.$store.getters.token});
            },
            getCauses(){
                console.log("getting causes...");
                this.getCauseList({token:this.$store.getters.token})
                    .then(()=>{
                        console.log("cause list:");
                        console.log(this.causes);
                        this.causeList=this.causes;
                    })
            }
        }
    }

</script>

