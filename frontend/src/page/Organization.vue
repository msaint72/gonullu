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
                            description="Organization Causes">
                        <b-form-tags
                                v-model="form.causes"
                                placeholder="Enter organization causes"
                                no-add-on-enter
                                class="mb-2"
                        ></b-form-tags>
                    </b-form-group>

                    <b-form-group
                            description="Organization description">
                        <b-form-textarea
                                rows="3"
                                max-rows="6"
                                v-model="form.description"
                                placeholder="Enter organization description"
                        ></b-form-textarea>
                    </b-form-group>
                    <b-form-group
                            label-size="lg"
                            label="Address">
                        <b-form-group  description="Address">
                            <b-form-input
                                    id="input-4"
                                    v-model="form.address"
                                    required
                                    placeholder="Enter organization address"
                            ></b-form-input>

                        </b-form-group>
                        <b-form-group  description="Province">
                            <b-form-select v-model="form.province" :options="provinces" size="sm" class="mt-3"></b-form-select>
                        </b-form-group>

                        <b-form-group  description="District">
                            <b-form-select v-model="form.district" :options="districts" size="sm" class="mt-3"></b-form-select>
                        </b-form-group>

                        <b-form-group  description="Zipcode">
                            <b-form-input
                                    id="zipcode"
                                    v-model="form.zipcode"
                                    type="text"
                                    required
                                    placeholder="Enter zipcode"
                            ></b-form-input>
                        </b-form-group>
                    </b-form-group>

                    <b-form-group  description="Phone">
                            <b-form-input
                                id="tel"
                                v-model="form.tel"
                                type="tel"
                                required
                                placeholder="Enter phone number"
                        ></b-form-input>
                    </b-form-group>
                    <b-form-group  description="Web address">
                        <b-form-input
                                id="url"
                                v-model="form.url"
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
<script>

    export default {
        data() {
            return {
                form: {
                    name: '',
                    causes: [],
                    description:'',
                    address: '',
                    province:'',
                    district:'',
                    zipcode:'',
                    tel:'',
                    url:'',
                    checked: []
                },
                show: true,
                provinces: [{ text: 'Select Province', value: null }, 'Ankara', 'İstanbul', 'İzmir', 'Konya'],
                districts: [{ text: 'Select District', value: null }, 'Çankaya', 'Keçiören', 'Yenimahalle'],
            }
        },
        methods: {
            submit(){
                console.log(this.form);
            }
        }
    }

</script>

