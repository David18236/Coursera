import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit, ViewChild, Inject } from '@angular/core';
import { Feedback, ContactType } from '../shared/feedback';
import { FeedbackService } from '../services/feedback.service';
import { flyInOut, expand } from '../animations/app.animation';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss'],
  host: { '[@flyInOut]': 'true', 'style': 'display: block;' },
  animations: [flyInOut(), expand()]
})

export class ContactComponent implements OnInit {
  @ViewChild('fform') feedbackFormDirective;

  feedbackForm: FormGroup;
  feedback: Feedback;
  contactType = ContactType;
  errMess: string;
  visibility = 'shown';
  spinnerVisibility: boolean;
  formVisibility: boolean;
  feedbackVisibility: boolean;

  formErrors = {
    'firstname': '',
    'lastname': '',
    'telnum': '',
    'email': '',
    'message': ''
  };

  validationMessages = {
    'firstname': {
      'required': 'First Name is required.',
      'minlength': 'First Name must be at least 2 characters long.',
      'maxlength': 'FirstName cannot be more than 25 characters long.'
    },
    'lastname': {
      'required': 'Last Name is required.',
      'minlength': 'Last Name must be at least 2 characters long.',
      'maxlength': 'Last Name cannot be more than 25 characters long.'
    },
    'telnum': {
      'required': 'Tel. number is required.',
      'pattern': 'Tel. number must contain only numbers.'
    },
    'email': {
      'required': 'Email is required.',
      'email': 'Email not in valid format.'
    },
    'message': {
      'required': 'Message is required.',
      'minlength': 'Message must be at least 2 characters long.'
    }
  };

  constructor(
    private fb: FormBuilder,
    private feedbackService: FeedbackService,
    @Inject('BaseURL') private BaseURL) {
    this.createForm();
    this.formVisibility = false;
    this.spinnerVisibility = false;
    this.feedbackVisibility = false;
  }

  ngOnInit() {
  }

  createForm(): void {
    this.feedbackForm = this.fb.group({
      firstname: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(25)]],
      lastname: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(25)]],
      telnum: ['', [Validators.required, Validators.pattern]],
      email: ['', [Validators.required, Validators.email]],
      agree: false,
      contacttype: 'None',
      message: ['', [Validators.required, Validators.minLength(2)]],
    });

    this.feedbackForm.valueChanges
      .subscribe(data => this.onValueChanged(data));

    this.onValueChanged(); // (re)set validation messages now
  }

  switchForm() {
    this.formVisibility = !this.formVisibility;
  }

  switchSpinner() {
    this.spinnerVisibility = !this.spinnerVisibility;
  }

  switchFeedback() {
    this.feedbackVisibility = !this.feedbackVisibility;
  }

  onSubmit() {
    this.feedback = this.feedbackForm.value;
    this.switchForm();
    this.switchSpinner();

    this.feedbackService.submitFeedback(this.feedback).subscribe(feedback => {
      this.feedback = feedback;
      this.switchSpinner();
      this.switchFeedback();
      setTimeout(() => {
        this.switchFeedback();
        this.switchForm();
      }, 5000);
    },
      errmess => { this.feedback = null; this.feedback = null; this.errMess = <any>errmess; }
    );

    console.log(this.feedback);

    this.feedbackForm.reset({
      firstname: '',
      lastname: '',
      telnum: '',
      email: '',
      agree: false,
      contacttype: 'None',
      message: ''
    });
    this.feedbackFormDirective.resetForm();
  }

  onValueChanged(data?: any) {
    if (!this.feedbackForm) { return; }
    const form = this.feedbackForm;
    for (const field in this.formErrors) {
      if (this.formErrors.hasOwnProperty(field)) {
        // clear previous error message (if any)
        this.formErrors[field] = '';
        const control = form.get(field);
        if (control && control.dirty && !control.valid) {
          const messages = this.validationMessages[field];
          for (const key in control.errors) {
            if (control.errors.hasOwnProperty(key)) {
              this.formErrors[field] += messages[key] + ' ';
            }
          }
        }
      }
    }
  }
}

