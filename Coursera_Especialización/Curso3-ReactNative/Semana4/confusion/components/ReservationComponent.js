import React, { Component } from 'react';
import { Text, View, ScrollView, StyleSheet, Picker, Switch, Alert, Button, Modal } from 'react-native';
import DatePicker from 'react-native-datepicker';

import * as Animatable from 'react-native-animatable';

import * as Permissions from 'expo-permissions';

import * as Calendar from 'expo-calendar';

import { Notifications } from 'expo';

class Reservation extends Component {

    constructor(props) {
        super(props);

        this.state = {
            guests: 1,
            smoking: false,
            date: '',
            showModal: false
        }
    }

    static navigationOptions = {
        title: 'Reserve Table',
    };

    toggleModal() {
        this.setState({ showModal: !this.state.showModal });
    }

    handleReservation() {
        this.presentLocalNotification(this.state.date)
        this.addReservationToCalendar(this.state.date)
    }

    resetForm() {
        this.setState({
            guests: 1,
            smoking: false,
            date: '',
            showModal: false
        });
    }

    showAlert() {
        Alert.alert(
            'Your Reservation is OK?',
            'Number of Guest: ' + this.state.guests + '\n' + 'Smoking? ' + this.state.smoking + '\n' +
            'Date and Time: ' + this.state.date,

            [
                { text: 'Cancel', onPress: () => { console.log('Cancel Pressed'); this.resetForm() }, style: 'cancel' },
                { text: 'OK', onPress: () => { console.log('Ok Pressed'); this.handleReservation(); this.resetForm() } },
            ],
            { cancelable: false }
        );
    }

    async obtainNotificationPermission() {
        let permission = await Permissions.getAsync(Permissions.USER_FACING_NOTIFICATIONS);
        if (permission.status !== 'granted') {
            permission = await Permissions.askAsync(Permissions.USER_FACING_NOTIFICATIONS);
            if (permission.status !== 'granted') {
                Alert.alert('Permission not granted to show notifications');
            }
        }
        return permission;
    }

    async presentLocalNotification(date) {
        await this.obtainNotificationPermission();
        Notifications.presentLocalNotificationAsync({
            title: 'Your Reservation',
            body: 'Reservation for ' + date + ' requested',
            ios: {
                sound: true
            },
            android: {
                sound: true,
                vibrate: true,
                color: '#512DA8'
            }
        });
    }

    async obtainCalendarPermission() {
        let permission = await Permissions.getAsync(Permissions.CALENDAR);
        if (permission.status !== 'granted') {
            permission = await Permissions.askAsync(Permissions.CALENDAR);
            if (permission.status !== 'granted') {
                Alert.alert('Permission not granted to use calendar');
            }
        }
        return permission;
    }

    //------------------------------------------------------------------------------------------------------------------------
    async getAndroidCal() {
        var androidCalendar
        var foundCal = false
        // retrieve internal calendars
        var androidCalendars = await Calendar.getCalendarsAsync();
        // iterate through them
        for (var x = 0; x < androidCalendars.length; x++) {
            // check each to see if their source name matches what you have
            if (androidCalendars[x]["source"]["name"] == "*your identifier*") {
                foundCal = true
                // save the calendar id and stop searching
                androidCalendar = androidCalendars[x]["id"]
                break
            }
        }
        // initial run
        if (foundCal === false) {
            androidCalendar = await createCalendar()
        }
        return androidCalendar
    }


    //  create a calendar for android 
    async createCalendar() {
        const newCalendarSource = {
            isLocalAccount: true,
            name: '*your identifier*'
        }

        const newCalendarID = await Calendar.createCalendarAsync({
            title: * your title*,
            color: * your color*,
            entityType: Calendar.EntityTypes.EVENT,
            sourceId: newCalendarSource.id,
            source: newCalendarSource,
            name: * calendar name*,
            ownerAccount: 'personal',
            accessLevel: Calendar.CalendarAccessLevel.OWNER,
        });

        return newCalendarID
    }
    //------------------------------------------------------------------------------------------------------------------------

    //async getDefaultCalendarSource() {
    //    const calendars = await Calendar.getCalendarsAsync();
    //    const defaultCalendars = calendars.filter(each => each.source.name === 'Default');
    //    return defaultCalendars[0].source;
    //}

    async addReservationToCalendar(date) {
        await this.obtainCalendarPermission();
        //await this.getDefaultCalendarSource();

        Notifications.presentLocalNotificationAsync({
            title: 'Con Fusion Table Reservation',
            body: 'Reservation for ' + date + ' requested',
            ios: {
                sound: true
            },
            android: {
                sound: true,
                vibrate: true,
                color: '#512DA8'
            }
        });

        Calendar.createCalendarAsync(null, {
            title: "Con Fusion Table Reservation",
            color: '#512DA8',
            name: 'Your Reservation',
            startDate: new Date(Date.parse(date)),
            endDate: new Date(Date.parse(date) + 2 * 60 * 60 * 1000),
            timeZone: 'Asia/Hong_Kong',
            location: '121, Clear Water Bay Road, Kowloon, Hong Kong'
        });
    }

    render() {
        return (
            <ScrollView>
                <Animatable.View animation="zoomIn" duration={2000}>
                    <View style={styles.formRow}>
                        <Text style={styles.formLabel}>Number of Guests</Text>
                        <Picker
                            style={styles.formItem}
                            selectedValue={this.state.guests}
                            onValueChange={(itemValue) => this.setState({ guests: itemValue })}>
                            <Picker.Item label="1" value="1" />
                            <Picker.Item label="2" value="2" />
                            <Picker.Item label="3" value="3" />
                            <Picker.Item label="4" value="4" />
                            <Picker.Item label="5" value="5" />
                            <Picker.Item label="6" value="6" />
                        </Picker>
                    </View>

                    <View style={styles.formRow}>
                        <Text style={styles.formLabel}>Smoking/Non-Smoking?</Text>
                        <Switch
                            style={styles.formItem}
                            value={this.state.smoking}
                            onTintColor='#512DA8'
                            onValueChange={(value) => this.setState({ smoking: value })}>
                        </Switch>
                    </View>

                    <View style={styles.formRow}>
                        <Text style={styles.formLabel}>Date and Time</Text>
                        <DatePicker
                            style={{ flex: 2, marginRight: 20 }}
                            date={this.state.date}
                            format=''
                            mode="datetime"
                            placeholder="select date and Time"
                            minDate="2017-01-01"
                            confirmBtnText="Confirm"
                            cancelBtnText="Cancel"
                            customStyles={{
                                dateIcon: {
                                    position: 'absolute',
                                    left: 0,
                                    top: 4,
                                    marginLeft: 0
                                },
                                dateInput: {
                                    marginLeft: 36
                                }
                            }}
                            onDateChange={(date) => { this.setState({ date: date }) }}
                        />
                    </View>

                    <View style={styles.formRow}>
                        <Button
                            onPress={() => this.showAlert()}
                            title="Reserve"
                            color="#512DA8"
                            accessibilityLabel="Learn more about this purple button"
                        />
                    </View>

                    <Modal
                        animationType={"slide"} transparent={false}
                        visible={this.state.showModal}
                        onDismiss={() => this.toggleModal()}
                        onRequestClose={() => this.toggleModal()}
                    >
                        <View style={styles.modal}>
                            <Text style={styles.modalTitle}>Your Reservation</Text>
                            <Text style={styles.modalText}>Number of Guests: {this.state.guests}</Text>
                            <Text style={styles.modalText}>Smoking?: {this.state.smoking ? 'Yes' : 'No'}</Text>
                            <Text style={styles.modalText}>Date and Time: {this.state.date}</Text>

                            <Button
                                onPress={() => { this.toggleModal(); this.resetForm(); }}
                                color="#512DA8"
                                title="Close"
                            />
                        </View>
                    </Modal>
                </Animatable.View>

            </ScrollView>
        );
    }
};

const styles = StyleSheet.create({
    formRow: {
        alignItems: 'center',
        justifyContent: 'center',
        flex: 1,
        flexDirection: 'row',
        margin: 20
    },

    formLabel: {
        fontSize: 18,
        flex: 2
    },

    formItem: {
        flex: 1
    },

    modal: {
        justifyContent: 'center',
        margin: 20
    },

    modalTitle: {
        fontSize: 24,
        fontWeight: 'bold',
        backgroundColor: '#512DA8',
        textAlign: 'center',
        color: 'white',
        marginBottom: 20
    },

    modalText: {
        fontSize: 18,
        margin: 10
    }
});

export default Reservation;