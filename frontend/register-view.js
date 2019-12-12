import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-password-field.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-item.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-text-field/src/vaadin-email-field.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';

class RegisterView extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;" id="vaadinVerticalLayout">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);"></vaadin-horizontal-layout>
 <vaadin-vertical-layout class="content" style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto; justify-content: center; flex-direction: row; align-items: center;" id="vaadinVerticalLayout1">
  <vaadin-form-layout id="vaadinFormLayout" style="align-self: center;">
   <vaadin-horizontal-layout style="flex-direction: column;">
    <vaadin-horizontal-layout>
     <vaadin-form-item id="vaadinFormItem">
      <label slot="label">First Name</label>
      <vaadin-text-field class="full-width" value="" id="firstName" has-value></vaadin-text-field>
     </vaadin-form-item>
    </vaadin-horizontal-layout>
    <vaadin-horizontal-layout>
     <vaadin-form-item id="vaadinFormItem1">
      <label slot="label">Last Name</label>
      <vaadin-text-field class="full-width" value="" id="lastName" has-value></vaadin-text-field>
     </vaadin-form-item>
    </vaadin-horizontal-layout>
    <vaadin-horizontal-layout>
     <vaadin-form-item>
      <label slot="label">Phone</label>
      <vaadin-text-field class="full-width" value="" id="phone" has-value></vaadin-text-field>
     </vaadin-form-item>
    </vaadin-horizontal-layout>
    <vaadin-horizontal-layout>
     <vaadin-form-item>
      <label slot="label">Email</label>
      <vaadin-email-field id="email" pattern="^[a-zA-Z0-9.!#$%&amp;’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$"></vaadin-email-field>
     </vaadin-form-item>
    </vaadin-horizontal-layout>
    <vaadin-horizontal-layout>
     <vaadin-form-item>
      <label slot="label">Password</label>
      <vaadin-password-field id="password"></vaadin-password-field>
     </vaadin-form-item>
    </vaadin-horizontal-layout>
    <vaadin-horizontal-layout>
     <vaadin-form-item>
      <vaadin-button theme="primary" id="submit">
        Submit 
      </vaadin-button>
     </vaadin-form-item>
    </vaadin-horizontal-layout>
   </vaadin-horizontal-layout>
  </vaadin-form-layout>
 </vaadin-vertical-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`{|}~-]+@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$" required="true"></vaadin-email-field>
     </vaadin-form-item>
    </vaadin-horizontal-layout>
    <vaadin-horizontal-layout>
     <vaadin-form-item>
      <label slot="label">Password</label>
      <vaadin-password-field id="password"></vaadin-password-field>
     </vaadin-form-item>
    </vaadin-horizontal-layout>
    <vaadin-horizontal-layout>
     <vaadin-form-item>
      <vaadin-button theme="primary" id="submit">
        Submit 
      </vaadin-button>
     </vaadin-form-item>
    </vaadin-horizontal-layout>
   </vaadin-horizontal-layout>
  </vaadin-form-layout>
 </vaadin-vertical-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`{|}~-]+@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$"></vaadin-email-field>
     </vaadin-form-item>
    </vaadin-horizontal-layout>
    <vaadin-horizontal-layout>
     <vaadin-form-item>
      <label slot="label">Password</label>
      <vaadin-password-field id="password"></vaadin-password-field>
     </vaadin-form-item>
    </vaadin-horizontal-layout>
    <vaadin-horizontal-layout>
     <vaadin-form-item>
      <vaadin-button theme="primary" id="submit">
        Submit 
      </vaadin-button>
     </vaadin-form-item>
    </vaadin-horizontal-layout>
   </vaadin-horizontal-layout>
  </vaadin-form-layout>
 </vaadin-vertical-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`{|}~-]+@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$"></vaadin-email-field>
      <vaadin-text-field class="full-width" value="" has-value></vaadin-text-field>
     </vaadin-form-item>
    </vaadin-horizontal-layout>
    <vaadin-horizontal-layout>
     <vaadin-form-item>
      <label slot="label">Password</label>
      <vaadin-password-field id="password"></vaadin-password-field>
     </vaadin-form-item>
    </vaadin-horizontal-layout>
    <vaadin-horizontal-layout>
     <vaadin-form-item>
      <vaadin-button theme="primary" id="submit">
        Submit 
      </vaadin-button>
     </vaadin-form-item>
    </vaadin-horizontal-layout>
   </vaadin-horizontal-layout>
  </vaadin-form-layout>
 </vaadin-vertical-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`{|}~-]+@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$"></vaadin-email-field>
      <vaadin-text-field class="full-width" value="" has-value></vaadin-text-field>
     </vaadin-form-item>
    </vaadin-horizontal-layout>
    <vaadin-horizontal-layout>
     <vaadin-form-item>
      <label slot="label">Password</label>
      <vaadin-password-field id="password"></vaadin-password-field>
     </vaadin-form-item>
    </vaadin-horizontal-layout>
    <vaadin-horizontal-layout>
     <vaadin-form-item>
      <vaadin-button theme="primary" id="submit">
        Submit 
      </vaadin-button>
     </vaadin-form-item>
    </vaadin-horizontal-layout>
   </vaadin-horizontal-layout>
  </vaadin-form-layout>
 </vaadin-vertical-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'register-view';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(RegisterView.is, RegisterView);
