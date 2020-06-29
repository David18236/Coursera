import { Component } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { IonicPage, NavController, NavParams, ViewController } from 'ionic-angular';

@IonicPage()
@Component({
  selector: 'page-comment',
  templateUrl: 'comment.html',
})
export class CommentPage {
  comment: FormGroup;

  constructor(public navCtrl: NavController, public navParams: NavParams,
    public viewCtrl: ViewController,
    private formBuilder: FormBuilder) {

    this.comment = this.formBuilder.group({
      author: ['', Validators.required],
      rating: 5,
      comment: ['', Validators.required],
      date: ['']
    });
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad CommentPage');
  }

  dismiss(data) {
    this.viewCtrl.dismiss(data);
  }

  onSubmit() {
    console.log(this.comment.value);
    var comment = this.comment.value;
    var d = new Date();
    comment.date = d.toString();
    this.comment.reset();
    this.viewCtrl.dismiss(comment);
  }
}
