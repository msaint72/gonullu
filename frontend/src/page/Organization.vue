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

                    <b-form-group
                            description="Organization description">
                        <b-form-textarea
                                rows="3"
                                max-rows="6"
                                v-model="form.summary"
                                placeholder="Enter organization description"
                        ></b-form-textarea>
                    </b-form-group>
                    <b-button type="submit" @click.prevent="submit">Save</b-button>
                </b-form>
            </b-col>
        </b-row>
    </b-container>
</template>
<script>

    import {mapGetters,mapActions} from 'vuex';
    export default {

    data() {
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
                show: true,
                provinces: [{ text: 'Select Province', value: null }, 'Ankara', 'İstanbul', 'İzmir', 'Konya'],
                districts: [{ text: 'Select District', value: null }, 'Çankaya', 'Keçiören', 'Yenimahalle'],
            }
        },
        computed :{
            ...mapGetters(['user']),
            ...mapGetters('organizationStore', ['organization']),
        },
        created(){
            console.log("getting org with id:"+this.user.orgId);

            this.$store.dispatch('getOrgData',
                { id:this.user.orgId,
                token:this.$store.getters.token} )
                .then(()=>{
                    this.form.name=this.organization.name
                    this.form.summary=this.organization.summary;
            });
        },
        mounted: function(){
        },
        methods: {
        ...mapActions(['saveOrganization']),
            submit(){
                console.log(this.organization);
                console.log(this.$store.getters.token);
                this.saveOrganization(
                        { organization: {
                                id : this.organization.id,
                                name : this.form.name,
                                summary: this.form.summary
                            }, token:this.$store.getters.token});
            }
        }
    }

</script>

